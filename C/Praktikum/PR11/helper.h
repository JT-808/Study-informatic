#ifndef HELPER_H
#define HELPER_H

#include <stdbool.h>

long getAvailableRAM();
long getFileSize(char path[]);
void closeCopy(char* src, long buffer, int source, int target);
int printFileSize(long bytes);
char **splitString(char string[]);
bool file_exists (char *filename);
int getBlock(char *path, int size);
char * attachMemBlock(char *path, int size);
bool destroyBlock(char *path);
char* trimWhitespace(char* str);
void writeMemToDisk(char* file_path, char* link_path, int size);
#endif