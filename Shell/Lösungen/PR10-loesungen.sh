#!/bin/bash
# Anzahl Parameter ueberpruefen
if [ $# -ge 1 ] && [ $# -le 5 ]
then
   # Diagramm ausgeben
    echo "^"
    # fuer alle Werte in der Parameterliste $@
    for k in $@
    do
        # Wert ueberpruefen, wenn zu klein oder zu gross Fehlermeldung und beenden
        if [ $k -lt 1 ] || [ $k -gt 20  ]
        then
            echo "Wert $k zu klein oder zu groß [1-20]"
            exit 1
        fi
        # echo -n: Ausgabe ohne Zeilenumbruch
        echo -n "|"
        j=0
        while [ $j -lt $k ]
        do
            echo -n "*"
            let j=j+1
        done
        # Zeilenumbruch
        echo
    done
    echo "|-------------------->"
else
    echo "Anzahl Werte zu klein oder zu groß [1-5]"
fi
b) Mögliche Lösung, andere Lösungen sind denkbar

#!/bin/bash
# Anzahl Werte eingeben
read -p "Anzahl der Werte [1-5]: " anzahl
# Anzahl Werte ueberpruefen
if [ $anzahl -ge 1 ] && [ $anzahl -le 5 ]
then
    # Feld mit fuenf Werten initialisieren
    werte=(0 0 0 0 0)
    # Werte eingeben
    k=0
    # solange k kleiner Anzahl Werte
    while [ $k -lt $anzahl ]
    do
        read -p "Bitte Wert `expr $k + 1` eingeben [1-20]: " wert
        # Wert ueberpruefen, wenn zu klein oder zu gross Fehlermeldung
        if [ $wert -lt 1  ] || [ $wert -gt 20 ]
        then
            echo "Wert zu klein oder zu groß"
        else
            # Wert im Feld Werte ablegen, k erhoehen
            werte[k]=$wert
            let k=k+1
        fi
    done
    # Diagramm ausgeben
    echo "^"
    # fuer alle Werte im Feld $werte
    for k in ${werte[*]}
    do
        # Wert 0 im Feld ignorieren
        if [ $k -lt 1 ]
        then
            continue
        fi
        # echo -n: Ausgabe ohne Zeilenumbruch
        echo -n "|"
        j=0
        while [ $j -lt $k ]
        do
            echo -n "*"
            let j=j+1
        done
        # Zeilenumbruch
        echo
    done
    echo "|-------------------->"
else
    echo "Anzahl zu klein oder zu groß"
fi
c) Mögliche Lösung, andere Lösungen sind denkbar

#!/bin/bash
# Anzahl Parameter ueberpruefen
if [ $# -gt 0 ]
then
    dateiname=$1
    if [ -f $dateiname ] && [ -r $dateiname ]
    then
        # Diagramm ausgeben
        echo "^"
        # Anzahl Zeilen zaehlen
        k=0
        # Zeile aus Datei lesen
        while read zeile
        do
            let k=k+1
            # Schleife abbrechen, wenn mehr als 5 Zeilen
            if [ $k -gt 5 ]
            then
                break
            fi
            # Wert ueberpruefen, wenn zu klein oder zu gross Fehlermeldung und beenden
            if [ $zeile -lt 1 ] || [ $zeile -gt 20  ]
            then
                echo "Wert $zeile zu klein oder zu groß [1-20]"
                exit 1
            fi
            # echo -n: Ausgabe ohne Zeilenumbruch
            echo -n "|"
            j=0
            while [ $j -lt $zeile ]
            do
                echo -n "*"
                let j=j+1
            done
            # Zeilenumbruch
            echo
        done < $dateiname
        echo "|-------------------->"
        if [ $k -gt 5 ]
        then
            echo "Mehr als 5 Zeilen, ignoriere restliche Zeilen"
        fi
    else
        echo "Kann nicht aus Datei $dateiname lesen"
        exit 1
    fi
else
    echo "Aufruf: balkendiagramm3.sh dateiname"
    exit 1
fi
2.

a) und b) Mögliche Lösung, andere Lösungen sind denkbar

#!/bin/bash
long=0
# Parameter ueberpruefen
if [ $# -eq 0 ]
then
    echo "Aufruf: wetter.sh [-L] dateiname"
    exit 1
elif [ $# -eq 1 ]
then
    if [ -f $1 ]
    then
        dateiname=$1
    else
        echo "$1 ist keine Datei"
        exit 1
    fi
elif [ $# -eq 2 ]
then
    if [ $1 = "-L" ]
    then
        long=1
    else
        echo "Unbekannter Parameter: $1"
        exit 1
    fi
    if [ -f $2 ]
    then
        dateiname=$2
    else
       echo "$2 ist keine Datei"
       exit 1
    fi
else
    echo "Zu viele Parameter"
    exit 1
fi

# Wetter ausgeben
str=()
k=0
# Datei wetter zeilenweise lesen (read => zeilenweise lesen (bei jeden Durchgang, wechselt er die Zeile))
while read zeile
do
    # Woerter der Zeile zaehlen
    n=`echo $zeile | wc -w`
    # Zufallszahl zwischen 1 und n
    let P=$RANDOM%$n+1
    # P-te Spalte in der Zeile merken
    str[k]=`echo "$zeile" | cut -f $P`
    let k=k+1
done < $dateiname
if [ $long -eq 1 ]
then
    echo "${str[0]} wird ${str[1]} Wetter bei ${str[2]} Grad, ${str[3]} Regen, ${str[4]} Wind, ${str[5]} Sonne."
else
    echo "${str[0]} wird ${str[1]} Wetter."
fi
