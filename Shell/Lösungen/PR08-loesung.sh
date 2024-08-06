#!/bin/bash
# Aufruf: systemdaten1
echo "SYSTEMDATEN: **************************************************************************"
echo "Heute ist `date +'%A, der %d. %B %Y'`."
echo "Mein aktuelles Verzeichnis ist `pwd`."
# $LOGNAME oder whoami für den Nutzer
# $HOSTNAME oder hostname für den Host
echo "Angemeldet bin ich als $LOGNAME am Host $HOSTNAME, der Terminaltyp ist $TERM."
# `who | wc -l` oder `user | wc -w` für die Anzahl Nutzer
echo "Derzeit sind an diesem Rechner `who | wc -l` zugangsberechtigte(r) Nutzer eingeloggt."
echo "********************************************************************** ENDE SYSTEMDATEN"
b)

#!/bin/bash
# Aufruf: systemdaten2 [-L]
# ohne Parameter: nur Datum
# Parameter -L für vollständige Ausgabe
# bei Aufruf mit irgendeinem Parameter oder zu vielen Parametern: nur Datum und Fehlermeldung mit exit 1
echo "SYSTEMDATEN: **************************************************************************"
echo "Heute ist `date +'%A, der %d. %B %Y'`."
if [ $# -gt 1 ]
then
  echo "Zu viele Parameter"
  exit 1
fi
if [ $# -eq 1 ]
then
  if [ $1 = "-L" ]
  then
    echo "Mein aktuelles Verzeichnis ist `pwd`."
    echo "Angemeldet bin ich als $LOGNAME am Host $HOSTNAME, der Terminaltyp ist $TERM."
    echo "Derzeit sind an diesem Rechner `who | wc -l` zugangsberechtigte(r) Nutzer eingeloggt."
  else
    echo "Falscher Parameter $1"
    exit 1
  fi
fi
echo "********************************************************************** ENDE SYSTEMDATEN"
c)

#!/bin/bash
# Aufruf: systemdaten3 [-L]
nochmal="j"
while [ $nochmal == "j" ]
do
  echo "SYSTEMDATEN: **************************************************************************"
  echo "Heute ist `date +'%A, der %d. %B %Y'`."
  if [ $# -gt 1 ]
  then
    echo "Zu viele Parameter"
    exit 1
  fi
  if [ $# -eq 1 ]
  then
    if [ $1 = "-L" ]
    then
      echo "Mein aktuelles Verzeichnis ist `pwd`."
      echo "Angemeldet bin ich als $LOGNAME am Host $HOSTNAME, der Terminaltyp ist $TERM."
      echo "Derzeit sind an diesem Rechner `who | wc -l` zugangsberechtigte(r) Nutzer eingeloggt."
    else
      echo "Falscher Parameter $1"
      exit 1
    fi
  fi
  echo "********************************************************************** ENDE SYSTEMDATEN"
  read -p "Nochmal? (j/n) " nochmal
done
 