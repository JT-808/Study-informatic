#!/bin/bash

#if [ $# -lt 1 ] || [ $# -gt 5 ]; then
#echo "falsche Anzahl an Parameter"
#fi

echo "Anzahl Zeilen eingeben:"
read reihen

for ((k=0; k<$reihen; k++)); do
    read -p "Bitte Anzahl Sterne für Zeile $(($k+1)) eingeben:" sterne
    werte+=("$sterne")
#werte = array <- hau die werte aus Zeile 11 in das Array
done

echo ^

for wert in ${werte[@]}; do
# lese die werte einzelnd aus dem Array 
# @ = alles im Array

echo -n "|"

    for ((i=0; i<$wert; i++)); do
        printf "*"
    done
    echo
    done
echo "--------------->"
