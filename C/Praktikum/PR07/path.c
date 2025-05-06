#include <stdio.h>
#include <stdlib.h>

#include "getFullPathName.h"


int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Usage: %s <name> <ENVname>\n", argv[0]);
        return EXIT_FAILURE;
    }

    char* name = argv[1];
    char* ENVname = argv[2];

    char *full_path = GetFullPathName(name, ENVname);

    if (full_path != NULL) {
        printf("Full path: %s\n", full_path);
        free(full_path);  // Speicher, der mit strdup() allokiert wurde, muss freigegeben werden
    } else {
        printf("File not found or environment variable not set.\n");
    }

    return EXIT_SUCCESS;
}
