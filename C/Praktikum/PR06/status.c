#include <stdio.h>
#include <sys/stat.h>
#include <time.h>

void printDateiInfo(const char *pfad) {
  struct stat dateiInfo;

  // stat() wird angewendet und vorher überprüft auf existenz
  if (stat(pfad, &dateiInfo) != 0) {
    perror("Fehler beim Abrufen der Dateiinformationen");
    return;
  }

  printf("Datei: %s\n", pfad);

  //Gerätenummer
  printf("Gerätenr.: %ld\n", dateiInfo.st_dev);

  //i-Node Nummer
  printf("inode: %ld\n",dateiInfo.st_ino);

  //Linkzähler (lu=lung unsigned)
  printf("Linkzaehler: %lu\n", dateiInfo.st_nlink);

  // Dateityp
  if (S_ISREG(dateiInfo.st_mode))
    printf("Typ: Reguläre Datei\n");
  else if (S_ISDIR(dateiInfo.st_mode))
    printf("Typ: Verzeichnis\n");
  else if (S_ISLNK(dateiInfo.st_mode))
    printf("Typ: Symbolischer Link\n"); // nicht in POSIX.1-1996
  else if (S_ISCHR(dateiInfo.st_mode))
    printf("Typ: Zeichengerät\n");
  else if (S_ISBLK(dateiInfo.st_mode))
    printf("Typ: Blockgerät\n");
  else if (S_ISFIFO(dateiInfo.st_mode))
    printf("Typ: FIFO / Named Pipe\n");
  else if (S_ISSOCK(dateiInfo.st_mode))
    printf("Typ: Socket\n"); // nicht in POSIX.1-1996
  else
    printf("Typ: Unbekannt\n");

  // Zugriffsrechte
  // & 0777 maskieren->nur die letzten 9 Bits. die tatsächlichen rwx-Rechte

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

  // Größe
  printf("Größe: %ld Bytes\n", (long)dateiInfo.st_size);

  //Besitzer und Gruppe im Klartext
  printf("UID: %d\n", dateiInfo.st_uid);
  printf("GID %d\n",dateiInfo.st_gid);

  // letzte Änderung
  printf("Letzte Änderung:   %s", ctime(&dateiInfo.st_mtime));

}

int main(int argc, char *argv[]) {
  if (argc < 2) {
    printf("Nutzung: %s <Dateiname>\n", argv[0]);
    return 1;
  }

  printDateiInfo(argv[1]);
  return 0;
}
