#!/bin/sh

#Zählschleife
# (hat Probleme bei Dateien mit Leerzeichen im Namen) -> siehe Ergebnis

# for kann nicht mehr als 9 Parameter

for i in $( ls );
do
    echo item $i
done


# while schleife
k=0
while [ $k -lt 3 ]; do
    echo Zahl $k
    let k=k+1               # k++ geht nicht
done

# finde alle Datein im Ordner -> pipe in die while schleife 
# red ließt es aus

find . -iname "*"| while read f
do
    echo "Datei:" $f       
done



# until = solange bis

until kommando_erfolgreich
do 
# anweisungen ...
done