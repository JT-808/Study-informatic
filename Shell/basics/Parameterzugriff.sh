#!/bin/sh

echo " Mein Name lautet $0"
echo "Es wurden $# Paramenter übergeben"
echo "1. Parameter = $1"
echo "2. Parameter = $2"
echo "3. Parameter = $3"
echo "alle Parameter: $*"
echo "Meine PID: $$"



# mit  $ ./Parameterzugriff.sh Eins Zwei Drei ausführen
# -> damit werden die Parameter gesetzt