#!/bin/bash
while : 
do
    echo "Heute ist $(date '+%A, der %d.%B %Y')" 
    echo "Mein aktuelles Verzeichnis ist $(pwd)."
    echo "Angemeldet bin ich als $USER am Host $HOSTNAME, der Terminaltyp ist $TERM."
    echo "Derzeit sind an diesem Rechner $(who | wc -l)  zugangsberechtigte Nutzer eingeloggt."
    read -p "Soll diese Abfrage wiederholt werden (j/n): " antwort
    if [ "$antwort" != "j" ]; then
echo "Auf Wiedersehen"
exit 1
fi
done