#!/bin/bash
set `date`


while :
do             # <- Endlosschleife
echo Heute ist $1 der $2 $3 $4.
echo Mein aktuelles Verzeichnis ist `pwd`.
echo Angemeldet bin ich als `whoami` am Host $HOSTNAME, der Terminaltyp ist $TERM .
echo Derzeit sind an diesem Rechner $(who | wc -l) zugangsberechtigte Nutzer eingeloggt.
echo ************************************************************ ENDE SYSTEMDATEN
echo Wiederholung?


  echo "1" ja
  echo "2" nein
echo "Zahl eingeben"
read TEMP

case $TEMP in 
    1) head -4 $0 | tail -1 ;;
    2) break ;;
esac
done 


