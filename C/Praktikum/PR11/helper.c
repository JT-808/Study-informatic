#include <stdlib.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/types.h>
#define _GNU_SOURCE
#include <stdio.h>
#include <sys/sysinfo.h>
#include <unistd.h>
#include <sys/stat.h>
#include <stdbool.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <ctype.h>

#define server_id 1337;
#define client_id 31337;

long getAvailableRAM(){
    return(get_avphys_pages() * sysconf(_SC_PAGESIZE));
}

long getFileSize(char path[]){
    struct stat fileStat;
    if(stat(path, &fileStat) < 0){
        fprintf(stderr,"[getFileSize] Fehler: Datei kann nicht geöffnet werden");
        return -1;
    } else {
        return(long long)fileStat.st_size;
    }
}

void closeCopy(char* src, long buffer, int source, int target){
    if(src != NULL){
        munmap(src, buffer);
    }
    close(source);   
    close(target); 
}

char **splitString(char string[]) {
    char **result = malloc(10 * sizeof(char*));
    char *token;
    int i = 0;

    token = strsep(&string, ":");
    while (token) {
        result[i++] = token;
        token = strsep(&string, ":");
    }
    result[i] = NULL;
    return result;
}

// TODO: Files >= 2GB?
bool file_exists (char *filename) {
  struct stat   buffer;   
  return (stat (filename, &buffer) == 0);
}

/**
Resolves the shared memory block associated with
a file using ftok and shmget and returns it

    @param path points to the location of the associated 
    file in the file system 
    @param size specifies the size of the shared memory segment/block
    @return 
*/
int getBlock(char *path, int size){
    key_t key = ftok(path, 0);
    if(key == -1){
        fprintf(stderr, "Failed to convert pathname to System V IPC key");
        return -1;
    }
    // rw-r--r-- | Create block if not present
    return shmget(key, size, 0644 | IPC_CREAT);
}


/**
    Responsible for loading the shared block into memory.

    @param path points to the location of the associated path points
    to the location of the associated 
    @param size specifies the size of the shared memory segment/block
    @return the address of the attached shared memory segment
*/
char * attachMemBlock(char *path, int size){
    int block_id = getBlock(path, size);
    char *result = NULL;

    if(block_id == -1){
        fprintf(stderr, "attachMemBlock: Couldn't resolve block id.\n");
        exit(EXIT_FAILURE);
    }

    result = shmat(block_id, NULL, 0);
    if(result == (void *) -1){  // Check for (void *) -1, not NULL
        fprintf(stderr, "attachMemBlock: Failed to attach shared memory segment\n");
        exit(EXIT_FAILURE);
    }
    return result;
}

/**
    
*/
void writeMemToDisk(char* file_path, char* link_path, int size){
    char *block = attachMemBlock(link_path, size);
    if(block == NULL){
        fprintf(stderr, "readFromMem: couldn't get block\n");
        exit(EXIT_FAILURE);
    }

    // Open the file for writing
    FILE *file = fopen(file_path, "wb");
    if (file == NULL) {
        fprintf(stderr, "readFromMem: couldn't open file for writing\n");
        shmdt(block);
        exit(EXIT_FAILURE);
    }

    // Write block contents to file byte by byte
    size_t written = fwrite(block, sizeof(char), size, file);
    if (written != size) {
        fprintf(stderr, "Error writing to file. Expected to write %d bytes, but wrote %zu bytes.\n", size, written);
    }

    // Close the file
    fclose(file);
    shmdt(block);
}


char* trimWhitespace(char* str) {
    if(str == NULL){
        fprintf(stderr,"I just received an empty message. That's invalid!\n");
        return NULL;
    }
    char* end;

    // Trim leading space
    while (isspace((unsigned char)*str)) str++;

    // Trim trailing space
    end = str + strlen(str) - 1;
    while (end > str && isspace((unsigned char)*end)) end--;

    // Null terminate after the last non-whitespace character
    *(end + 1) = '\0';

    return str;
}