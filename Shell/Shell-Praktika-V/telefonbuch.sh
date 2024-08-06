#!/bin/bash

datei=./telefonbuch.dat

# Überprüfen, ob die Datei existiert
if [ ! -f "$datei" ]; then
    echo "Die Datei $datei existiert nicht."
    exit 1
fi

# wenn -p, dann zähle Zeilen, gebe inhalt der Zeilen wieder und ersetze , : mit tabulator
if [ "$1" == "-p" ]; then
personen=$(wc -l < $datei)
liste=$(head -n "$personen" "$datei")
listemodifiziert=$(echo "$liste" | tr ',:' '\t\t')
echo "$listemodifiziert"
fi

# wenn suchbegriff vorhanden, dann suche den Begriff, gebe wieder und ersetze ,. mit Tabulator. 
# Falls Suchbegriff nicht vorhanden -> Fehlermeldung 
if [ "$1" == "-s" ]; then
suchbegriff=$(grep -i $2 $datei)  # -i = ignoriert groß und kleinschreibung
     if [ -n "$suchbegriff" ]; then     # -n = Prüfung: ist nicht leer?
    suchbegriffmodifiziert=$(echo "$suchbegriff" | tr ',:' '\t\t')
    echo $suchbegriffmodifiziert
    else
    echo "nicht vorhanden"
    exit 1
    fi
fi


if [ "$1" == "-a" ]; then

# überprüfung auf anzahl Parameter

    if [ $# -ne 4 ]; then
    echo "falsche Anzahl Parameter"
    exit 1

        #überprüfung vom Eintrag schon vorhanden

        # noch nicht fertig
        eintraege=$(grep -i "$2" "$datei" | grep -i "$4")
        if [ -n "$eintraege" ]; then
        echo "schon vorhanden"
        exit 1
        fi
    fi


# passt alles, dann häng es ins Telefonbuch hinten dran

echo  "$2" "$3" "$4" >> $datei
echo "erfolreich angelegt"

fi    


datei=./telefonbuch.dat
if [ "$1" == "-p" ]; then

# sed löscht inhalt von datein

sed -i -e "/$2/d" $datei
echo gelöscht
else 
echo nicht gefunden
fi