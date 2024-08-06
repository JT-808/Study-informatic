#!/bin/bash


# Zufallszahl erraten

zzahl=$((1 + RANDOM % 100))
ezahl=0
counter= 0
while [ $ezahl -ne $zzahl ]; do
echo Bitte Zahl eingeben
read ezahl
counter=$((counter+1))
if [ $counter -eq 10 ]; then
break
if [ $ezahl -lt $zzahl ]; then
echo zu klein
elif [ $ezahl -gt $zzahl ]; then
echo zu groß
else echo "RICHTIG!"
fi
fi
echo $counter
done
