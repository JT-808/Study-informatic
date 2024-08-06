#!/bin/bash

#if [ "$#" -ne 3 ]; then
 #   echo "Fehler: Das Skript benötigt genau drei Parameter."
  #  exit 1
#fi    


echo Bitte Wert 1 eingeben
read wert1
echo Bitte Wert 2 eingeben
read wert2
echo Bitte Wert 3 eingeben
read wert3

    for wert in "$wert1" "$wert2" "$wert3"; do
        for ((i=1; i<=$wert; i++)); do
            printf  "*"
        done
        echo
    done



