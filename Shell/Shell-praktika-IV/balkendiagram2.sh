#!bin/bash

datei=./Messwerte.dat

# Überprüfen, ob die Datei existiert
if [ ! -f "$datei" ]; then
    echo "Die Datei $datei existiert nicht."
    exit 1
fi

while read wert; do

# überprüfen ob Zeile nur Zahlen enthält
if [[ $wert != [0-9] ]]; then
echo "Zeile enthält keine Zahl"
exit 1
fi

    for ((i=1; i<=$wert; i++)); do
        printf  "*"
    done
    echo
done < "$datei"


## Schönerer Ansatz ->
# Verarbeiten des Inhalts der Datei mit cat und for

cat "$datei" | while read wert; do
    for ((i=1; i<=$wert; i++)); do
        printf  "*"
    done
    echo
done