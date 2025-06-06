#ifndef MSGCOPY_H
#define MSGCOPY_H

#include <stddef.h>


#define MSGTYPE_FILENAME 1     
#define MSGTYPE_RESPONSE 2     
#define MSGTYPE_FILEDATA 3     
#define MSGTYPE_RESULT 4       

#define MAX_FILENAME 256
#define BLOCK_SIZE 1024 //

#define STATUS_OK 0
#define STATUS_ERR_EXISTS 1
#define STATUS_ERR_GENERAL 2

// Client → Server: Zieldateiname
struct msg_filename {
    long mtype;
    char filename[MAX_FILENAME];
};

// Server → Client: Antwortstatus
struct msg_response {
    long mtype;
    int status; //0 = OK, 1 = Datei existiert, 2 = Fehler
};

// Client → Server: Datenblock
struct msg_fileblock {
    long mtype;
    size_t size; // Gültige Daten in data[]
    char data[BLOCK_SIZE];
};

// Server → Client: Abschlussmeldung
struct msg_result {
    long mtype;
    int status; // 0 = OK, != 0 = Fehler
};

#endif // MSGCOPY_H
