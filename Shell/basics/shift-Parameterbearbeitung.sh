#!/bin/sh

#Problem: man kann nur 10 Parameter übergeben
# siehe  $ bash shift-Parameterbearbeitung.sh 1 2 3 4 5 6 7 8 9 10

echo "$# Argumente"
echo "$*"
shift           # nach shift wird das erste Argument nicht mehr verwendet
echo "Nachdem Shift ausgeführt wurde..."
echo "$# Argumente"
echo "$*"


# $ bash shift-Parameterbearbeitung.sh 1 2 3 4 5 6
#eigeben
echo "-----"
while [ $# -gt 0 ]
do
echo "mache was mit: $1"
shift 
done

#Lösung: Shift löscht immer das erste und führt fort