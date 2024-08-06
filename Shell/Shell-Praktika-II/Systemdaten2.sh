#!/bin/bash
if [ $# -eq 0 ]; then
    eval $(head -13 $0 | tail -1)
    exit 1
elif [ $# -gt 0 ]; then
    echo "Zu viele Parameter"
    exit 1
fi

set `date`

echo "Heute ist $1 der $2 $3 $4."
echo "Mein aktuelles Verzeichnis ist $(pwd)."
echo "Derzeit sind an diesem Rechner $(who | wc -l) zugangsberechtigte Nutzer eingeloggt."
echo "Angemeldet bin ich als $(whoami) am Host $HOSTNAME, der Terminaltyp ist $TERM."
echo "************************************************************ ENDE SYSTEMDATEN"
