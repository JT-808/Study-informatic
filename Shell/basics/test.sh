#!/bin/sh

# mit test wird getestet
# in dem Fall ob sich datei input.sh Verzeichniss existiert

if test -e basics/input.sh
#Alternative -> if [ -e out ]
then
echo true
else 
echo false
fi

# -e= existiert
# -s= existiert und ist nicht leer
# -d = ist Verzeichnis
# -w = schreibbar