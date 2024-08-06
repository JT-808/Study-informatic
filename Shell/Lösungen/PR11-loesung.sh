#Mögliche Lösung ohne Funktionen, andere Lösungen sind denkbar

#!/bin/bash
# Anzahl Parameter ueberpruefen
if [ $# -lt 2 ]
then
    echo "Falsche Anzahl von Parameter"
    exit 1
fi

case $1 in
-p)
    # Ausgabe des Telefonbuchs
    tr [,:] " " < telefonbuch.dat
;;
-s)
    # Suche im Telefonbuch
    # -i: Groß-/Kleinschreibung ignorieren, $2: Suchbegriff, $3: Telefonbuch-Datei
    result=`grep -i $2 $3`
    # wenn Zeichenkette nicht leer, dann Ausgabe sonst Fehlermeldung
    if [ -n "$result" ]
    then
        echo $result | tr " " "\n" | tr [,:] " "
    else
        echo "Eintrag nicht gefunden"
        exit 1
    fi
;;
-a)
    # Eintrag hinzufuegen
    # -F: Suchbegriff nicht als regulären Ausdruck behandeln, $2: Suchbegriff, $3: Telefonbuch-Datei
    result=`grep -F $2 $3`
    # wenn Zeichenkette leer, dann Eintrag hinzufuegen
    if [ -z "$result" ]
    then
        echo $2 >> $3
    fi
;;
-d)
    # Eintrag loeschen
    # -i: Groß-/Kleinschreibung ignorieren, $2: Suchbegriff, $3: Telefonbuch-Datei
    result=`grep -i $2 $3`
    # wenn Zeichenkette nicht leer, dann Ausgabe, Abfrage ob geloescht werden soll und loeschen sonst Fehlermeldung
    if [ -n "$result" ]
    then
        echo "Eintrag gefunden"
        echo $result | tr " " "\n" | tr [,:] " "
        read -p "Eintrag löschen [j/n]? " eingabe
        if [ $eingabe == "j" ]
        then
            # Suche nach allen Eintraegen, die nicht Suchbegriff enthalten, speichern in temporaerer Datei
            grep -i -v $2 $3 > telefonbuch.tmp
            # Telefonbuch-Datei loeschen
            rm $3
            # temporaere Datei in Telefonbuch-Datei umbenennen
            mv telefonbuch.tmp $3
            echo "Eintrag gelöscht"
        else
            echo "Löschvorgang abgebrochen"
        fi
    else
        echo "Eintrag nicht gefunden"
        exit 1
    fi
;;
*)
    echo "Falscher Parameter"
    exit 1
;;
esac
Mögliche Lösung mit Funktionen, andere Lösungen sind denkbar

#!/bin/bash
# Anzahl Parameter ueberpruefen
if [ $# -lt 2 ]
then
    echo "Falsche Anzahl von Parameter"
    exit 1
fi

# Funktion fuer die Ausgabe des Telefonbuchs
show() {
    tr [,:] " " < $1
}

# Funktion fuer die Suche
search() {
    # -i: Groß-/Kleinschreibung ignorieren, $2: Suchbegriff, $3: Telefonbuch-Datei
    result=`grep -i $1 $2`
    # wenn Zeichenkette nicht leer, dann Ausgabe sonst Fehlermeldung
    if [ -n "$result" ]
    then
        echo $result | tr " " "\n" | tr [,:] " "
    else
        echo "Eintrag nicht gefunden"
        exit 1
    fi
}

# Funktion zum Hinfuegen eines Eintrags
add() {
    # -F: Suchbegriff nicht als regulären Ausdruck behandeln, $2: Suchbegriff, $3: Telefonbuch-Datei
    result=`grep -F $1 $2`
    # wenn Zeichenkette leer, dann Eintrag hinzufuegen
    if [ -z "$result" ]
    then
        echo $1 >> $2
    fi
}

# Funktion zum Loeschen eines Eintrags
delete() {
    # -i: Groß-/Kleinschreibung ignorieren, $2: Suchbegriff, $3: Telefonbuch-Datei
    result=`grep -i $1 $2`
    # wenn Zeichenkette nicht leer, dann Ausgabe, Abfrage ob geloescht werden soll und loeschen sonst Fehlermeldung
    if [ -n "$result" ]
    then
        echo "Eintrag gefunden"
        echo $result | tr " " "\n" | tr [,:] " "
        read -p "Eintrag löschen [j/n]? " eingabe
        if [ $eingabe == "j" ]
        then
            # Suche nach allen Eintraegen, die nicht Suchbegriff enthalten, speichern in temporaerer Datei
            grep -i -v $1 $2 > telefonbuch.tmp
            # Telefonbuch-Datei loeschen
            rm $2
            # temporaere Datei in Telefonbuch-Datei umbenennen
            mv telefonbuch.tmp $2
            echo "Eintrag gelöscht"
        else
            echo "Löschvorgang abgebrochen"
        fi
    else
        echo "Eintrag nicht gefunden"
        exit 1
    fi
}

case $1 in
-p)
    show $2
;;
-s)
    search $2 $3
;;
-a)
    add $2 $3
;;
-d)
    delete $2 $3
;;
*)
    echo "Falscher Parameter"
    exit 1
;;
esac
2.

a) und b)

Mögliche Gesamtlösung für die beiden Teilaufgaben, andere Lösungen sind denkbar

#!/bin/bash
# Aufruf: dateigroesse.sh verzeichnis [-r]
# Anzahl Parameter pruefen
if [ $# -eq 0 ] || [ $# -gt 2 ]
then
    echo "Falscher Aufruf: $0 verzeichnis [-r]"
    exit 1
fi

# if [ -d $1 ]: wenn $1 Verzeichnis
# if [ ! -d $1 ]: wenn $1 kein Verzeichnis, "!" logisches NICHT
if [ ! -d $1 ]
then
    echo "$1 ist kein Verzeichnis"
    exit 1
fi

if [ $# -eq 1 ]
then
    # alle Dateien (-type f)  nur im Verzeichnis $1 (-maxdepth -1) finden
    # und getrennt durch Leerzeichen auflisten
    list=`find $1 -maxdepth 1 -type f | tr "\n" " "`
elif [ $2 == "-r" ]
then
    # alle Dateien (-type f) im Verzeichnis $1 und rekursiv darunter finden
    # und getrennt durch Leerzeichen auflisten
    list=`find $1 -type f | tr "\n" " "`
else
    echo "Falscher Parameter $2"
    exit 1
fi
# du: disk usage, Speicherplatzbedarf fuer eine Datei ermitteln (abschaetzen)
# -b, --bytes: in Bytes
# -c, --total: Gesamtsumme bilden
du -c -b $list