#!/bin/bash

# zufällige Zahl
# +2, weil zahl 0 und 1. Spalte ausschließen (fang ab 2 an )
# sprich zwischen 2,3,4,5 auswählen

reihe1=$((2 + RANDOM % 4))
reihe2=$((2 + RANDOM % 2))
reihe3=$((2 + RANDOM % 5))
reihe4=$((2 + RANDOM % 5))
reihe5=$((2 + RANDOM % 6))
reihe6=$((2 + RANDOM % 4))

datei=./wetterdaten.dat

# Überprüfen, ob die Datei existiert
if [ ! -f "$datei" ]; then
    echo "Die Datei $datei existiert nicht."
    exit 1
fi

wort1=$(head -n 1 "$datei" | awk '{print $'$reihe1'}')
wort2=$(head -n 2 "$datei"| tail -1 | awk '{print $'$reihe2'}')

echo $wort1 wird $wort2 Wetter.

#überprüfen ob option -L genutzt wird
if [ $1 == "-L" ]; then
wort3=$(head -n 3 "$datei"| tail -1 | awk '{print $'$reihe3'}')
wort4=$(head -n 4 "$datei"| tail -1 | awk '{print $'$reihe4'}')
wort5=$(head -n 5 "$datei"| tail -1 | awk '{print $'$reihe5'}')
wort6=$(head -n 6 "$datei"| tail -1 | awk '{print $'$reihe6'}')

echo $wort1 wird $wort2 Wetter mit ca. $wort3 Grad Celsius, $wort4 Regen, $wort5 Wind, $wort6 Sonne.
fi

