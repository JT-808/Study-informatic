#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <limits.h>

char* GetFullPathName(char* name, char* ENVname) {
    char *env_path = getenv(ENVname);  // Holt den Wert der Umgebungsvariable ENVname
    if (env_path == NULL) {
        return NULL;  // Wenn die Umgebungsvariable nicht existiert, gib NULL zurück
    }

    // Puffer für den vollen Pfad (größtmögliche Pfadlänge)
    char full_path[PATH_MAX];
    char *dir = strtok(env_path, ":");  // Zerlegt den PATH in einzelne Verzeichnisse

    while (dir != NULL) {
        // Versuche, die Datei im aktuellen Verzeichnis zu finden
        snprintf(full_path, sizeof(full_path), "%s/%s", dir, name);
        
        // Überprüfe, ob die Datei existiert
        if (access(full_path, F_OK) == 0) {
            // Wenn gefunden, gib den vollen Pfad zurück
            return strdup(full_path);
        }

        // Gehe zum nächsten Verzeichnis im PATH
        dir = strtok(NULL, ":");
    }

    return NULL;  // Wenn die Datei nicht gefunden wurde
}



/*
Umgebungsvariablen (Environment Variables) – wichtige Beispiele:

| Variable   | Bedeutung                                              |
|------------|--------------------------------------------------------|
| PATH       | Doppelpunkt-getrennte Liste von Verzeichnissen, in denen nach ausführbaren Dateien gesucht wird (z.B. bei exec(), system() usw.) |
| HOME       | Das Home-Verzeichnis des aktuellen Benutzers          |
| USER       | Der Benutzername des angemeldeten Users               |
| SHELL      | Pfad zur verwendeten Shell, z.B. /bin/bash            |
| LANG       | Sprache und Gebietsschema (z.B. de_DE.UTF-8)          |
| TERM       | Typ des Terminal-Emulators                            |
| PWD        | Aktuelles Arbeitsverzeichnis                          |
| LOGNAME    | Login-Name des Benutzers                              |

Verwendbar z. B. über: getenv("PATH")
*/
