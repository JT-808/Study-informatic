#include <stdio.h>
#include <sys/stat.h>
#include <stdlib.h>

int isRegularFile(const char *dateiname) {
    struct stat path_stat;

    // stat() gibt 0 zurück, wenn erfolgreich
    if (stat(dateiname, &path_stat) != 0) {
        perror("gibts nicht");  // gibt Fehler aus, z.B. falls Datei nicht existiert
        return 0;
    }

    // Prüft, ob es eine reguläre Datei ist
    return S_ISREG(path_stat.st_mode);
}
