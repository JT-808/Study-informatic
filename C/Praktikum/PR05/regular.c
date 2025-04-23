#include <stdio.h>
#include <sys/stat.h> //stat()



int isRegularFile(const char *dateiname) {
    struct stat dateiInfo;
   //ohne Fehlerbehandlung: stat(dateiname, &dateiInfo);


    //stat() wird angewendet und vorher überprüft auf existenz
    if (stat(dateiname, &dateiInfo) != 0) {
        perror("gibts nicht");  // gibt Fehler aus, z.B. falls Datei nicht existiert
        return 0;
    }

    // Prüft, ob es eine reguläre Datei ist
    return S_ISREG(dateiInfo.st_mode);
    
}
