#!/bin/sh

while :
do             # <- Endlosschleife
    echo "-----------------------------"
    echo "-0--> Ende-------------------"
    echo "-1--> Datum und Uhrzeit------"
    echo "-2--> aktuelles Verzeichnis--"
    echo "-3--> Inhalts Verzeichnis----"
    echo "-----------------------------"
echo "Zahl eingeben"
read TEMP
$TEMP

case $TEMP in
    0) kill -9 0 ;;
    1) date ;;
    2) pwd ;;
    3) ls ;;
    *) echo "Befehl";;
esac
done  # done beendet die While do schleife