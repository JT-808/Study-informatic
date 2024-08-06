#!/bin/bash

# überprüfe ob die Option -w genutze wurde
if [ "$1" == "-w" ]; then
# Schreibe das aktuelle Datum und die Uhrzeit in die .lastlog-Datei
    echo `date` >> lastlog
# Überprüfe, ob das Skript ohne Option aufgerufen wurde
elif [ $# -eq 0 ]; then
if [ -e "lastlog" ]; then
# zeige den letzten Eintrag in der lastlog datei
cat lastlog | tail -1
else 
echo Datei existiert nicht
fi
fi