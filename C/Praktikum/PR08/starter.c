#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

//fork() = erzeugung (Kind)-Prozess mit selben Code
//zum Start eines anderen Programm (code) muss Kindprozess exec() aufrufen
//exec() ersetzt das laufende Programm durch das aufgerufene.
//-> !Es entsteht kein neuer Prozess!

int main(int argc, char** argv) {

    int pid = fork();

    if (pid < 0) {
        perror("Parent: Fork fehlgeschlagen");
        return EXIT_FAILURE;
    } else if (pid == 0) {
        // In argv muss der Programmname mit übergeben werden
        // cvp sucht im PATH
        if (execvp(argv[1], &argv[1]) < 0) {
            perror("execv");
        }
        // * Wildcard wird nicht expandiert (keine Shell)
        return 0;
    } else {
        int status;
        wait(&status);
    }

    return 0;
}


/*
 * Dieses Programm startet ein anderes Programm mit beliebigen Argumenten.
 * - Es erzeugt mit fork() einen Kindprozess.
 * - Im Kindprozess wird execvp() aufgerufen, um das gewünschte Programm zu starten.
 *   Dabei werden argv[1] (Programmname) und folgende Argumente übergeben.
 * - execvp() nutzt den PATH, um das Programm zu finden.
 * - Der Elternprozess wartet mit wait() auf die Beendigung des Kindprozesses.
 * - Bei Fehlern werden passende Fehlermeldungen ausgegeben.
 * Hinweis: Wildcards wie *.c werden nicht expandiert, da keine Shell verwendet wird.
 */


 /*
 Was passiert, wenn in obiger Aufgabe execv() anstelle execvp() verwendet wird?

-> man muss dann vollständigen Pfad zum auszuführenden Programm angeben
execv() - kein PATH-Suchmechanismus
execvp() - sucht automatisch im PATH (wie die Shell)
 */


