#!bin/bash
set `date`

echo "Heute ist $1 der $2 $3 $4."
echo "Mein aktuelles Verzeichnis ist `pwd`."
echo "Angemeldet bin ich als `whoami` am Host $(HOSTNAME), der Terminaltyp ist $TERM ."
echo "Derzeit sind an diesem Rechner $(who | wc -l) zugangsberechtigte Nutzer eingeloggt."
echo ************************************************************ ENDE SYSTEMDATEN

echo now?
options="Run Exit"
