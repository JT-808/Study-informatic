#include <stdio.h>
#include <sys/stat.h>
#include <time.h>
#include <dirent.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>

int isFolder(const char *pfad) {
    struct stat dateiInfo;
    if (stat(pfad, &dateiInfo) != 0) {
        return 0;  // Fehler zählt hier als "nicht Ordner"
    }
    return S_ISDIR(dateiInfo.st_mode);
}

void printDateiInfo(const char *pfad) {
    struct stat dateiInfo;

    if (stat(pfad, &dateiInfo) != 0) {
        perror(pfad);  // Pfad in Fehlermeldung aufnehmen
        return;
    }

    printf("Datei: %s\n", pfad);
    printf("Gerätenr.: %ld\n", dateiInfo.st_dev);
    printf("inode: %ld\n", dateiInfo.st_ino);
    printf("Linkzaehler: %lu\n", dateiInfo.st_nlink);

    if (S_ISREG(dateiInfo.st_mode))
        printf("Typ: Reguläre Datei\n");
    else if (S_ISDIR(dateiInfo.st_mode))
        printf("Typ: Verzeichnis\n");
    else if (S_ISLNK(dateiInfo.st_mode))
        printf("Typ: Symbolischer Link\n");
    else if (S_ISCHR(dateiInfo.st_mode))
        printf("Typ: Zeichengerät\n");
    else if (S_ISBLK(dateiInfo.st_mode))
        printf("Typ: Blockgerät\n");
    else if (S_ISFIFO(dateiInfo.st_mode))
        printf("Typ: FIFO / Named Pipe\n");
    else if (S_ISSOCK(dateiInfo.st_mode))
        printf("Typ: Socket\n");
    else
        printf("Typ: Unbekannt\n");

    printf("Zugriffsrechte (octal): %o\n", dateiInfo.st_mode & 0777);
    printf("Zugriffsrechte: %c%c%c%c%c%c%c%c%c\n",
           (dateiInfo.st_mode & S_IRUSR) ? 'r' : '-',
           (dateiInfo.st_mode & S_IWUSR) ? 'w' : '-',
           (dateiInfo.st_mode & S_IXUSR) ? 'x' : '-',
           (dateiInfo.st_mode & S_IRGRP) ? 'r' : '-',
           (dateiInfo.st_mode & S_IWGRP) ? 'w' : '-',
           (dateiInfo.st_mode & S_IXGRP) ? 'x' : '-',
           (dateiInfo.st_mode & S_IROTH) ? 'r' : '-',
           (dateiInfo.st_mode & S_IWOTH) ? 'w' : '-',
           (dateiInfo.st_mode & S_IXOTH) ? 'x' : '-');

    printf("Größe: %ld Bytes\n", (long)dateiInfo.st_size);
    printf("UID: %d\n", dateiInfo.st_uid);
    printf("GID: %d\n", dateiInfo.st_gid);
    printf("Letzte Änderung:   %s\n", ctime(&dateiInfo.st_mtime));
}

void verzeichnisInhaltAnzeigen(const char *verzeichnis) {
    DIR *dir;
    struct dirent *eintrag;
    //readdir() gibt einen Zeiger zurück daher *

    dir = opendir(verzeichnis);
    if (!dir) {
        perror("Fehler beim Öffnen des Verzeichnisses");
        return;
    }

    while ((eintrag = readdir(dir)) != NULL) {
        
        // Zugriff auf das Feld 'd_name' der Struktur, auf die 'eintrag' zeigt (über Zeiger mit ->)
            // "." und ".." überspringen
        if (strcmp(eintrag->d_name, ".") == 0 || strcmp(eintrag->d_name, "..") == 0)
            continue;

        // Vollständiger Pfad: Verzeichnis + "/" + Dateiname
        char vollerPfad[4096]; //4096 typische max Pfadlänge
        snprintf(vollerPfad, sizeof(vollerPfad), "%s/%s", verzeichnis, eintrag->d_name);

        printDateiInfo(vollerPfad);
        printf("\n");
    }

    closedir(dir);
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Nutzung: %s <Datei- oder Verzeichnisname>\n", argv[0]);
        return 1;
    }

    if (isFolder(argv[1])) {
        printf("Verzeichnis erkannt: %s\n\n", argv[1]);
        verzeichnisInhaltAnzeigen(argv[1]);
    } else {
        printDateiInfo(argv[1]);
    }

    return 0;
}
