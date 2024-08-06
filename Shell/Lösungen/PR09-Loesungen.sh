#!/bin/bash
# Aufruf: ./raten.sh
# Zufallszahl zwischen 0 und 99 (einschliesslich)
let n=$RANDOM%100
# Zaehler Anzahl Versuche
count=0
running="y"
echo "Ich habe mir eine Zahl zwischen 0 und 99 ausgedacht"
while [ $running == "y" ]
do
  read -p "Rate mal [0-99]: " eingabe
  # Zaehler Anzahl Versuche inkrementieren
  let count=$count+1
  if [ $eingabe -lt $n ]
  then
    echo "Die Zahl ist groesser"
  elif [ $eingabe -gt $n ]
  then
    echo "Die Zahl ist kleiner"
  else
    echo "Richtig"
    running="n"
  fi
  if [ $count -eq 10 ]
  then
    echo "10 Versuche, die richtige Zahl ist $n"
    exit
  fi
done
echo "Du hast $count Versuche gebraucht"
#!/bin/bash
# Aufruf: ./raten.sh
# Zufallszahl zwischen 0 und 99 (einschliesslich)
let n=$RANDOM%100
# Zaehler Anzahl Versuche
count=0
echo "Ich habe mir eine Zahl zwischen 0 und 99 ausgedacht"
eingabe=-1
while [ $eingabe -ne $n ]
do
  read -p "Rate mal [0-99]: " eingabe
  # Zaehler Anzahl Versuche inkrementieren
  let count=$count+1
  if [ $eingabe -lt $n ]
  then
    echo "Die Zahl ist groesser"
  elif [ $eingabe -gt $n ]
  then
    echo "Die Zahl ist kleiner"
  else
    echo "Richtig"
  fi
  if [ $count -eq 10 ]
  then
    echo "10 Versuche, die richtige Zahl ist $n"
    exit
  fi
done
echo "Du hast $count Versuche gebraucht"
d)

Zufallszahl kann mit shuf erzeugt werden, z.B. let n=`shuf -i 0-99 -n 1`

2.

a) Mögliche Lösung, andere Lösungen sind denkbar

#!/bin/bash
# Aufruf: last_login.sh [-w]
if [ $# -gt 1 ]
then
  echo "Falscher Aufruf: zu viele Parameter"
  exit 1
fi
if [ $# -eq 1 ]
then
  if [ $1 == "-w" ]
  then
    date >> ~/.lastlogin
  else
    echo "Falscher Aufruf: falscher Parameter"
  fi
else
  if [ -f ~/.lastlogin ]
  then
    tail -n 1 ~/.lastlogin
  else
    echo "Bisher kein Login ..."
  fi
fi
b) Mögliche Lösung, andere Lösungen sind denkbar

#!/bin/bash
# Aufruf: last_login.sh dateiname [-w]
if [ $# -gt 2 ]
then
  echo "Falscher Aufruf: zu viele Parameter"
  exit 1
fi
if [ $# -eq 2 ]
then
  if [ $2 == "-w" ]
  then
    date >> $1
  else
    echo "Falscher Aufruf: falscher Parameter"
  fi
elif [ $# -eq 1 ] && [ $1 != "-w" ]
then
  if [ -f $1 ]
  then
    tail -n 1 $1
  else
    echo "Datei $1 existiert nicht"
    echo "Bisher kein Login ..."
  fi
else
  echo "Falscher Aufruf: nicht genuegend Parameter"
fi
3.

a) bis c)

Mögliche Gesamtlösungen für die 3 Teilaufgaben, andere Lösungen sind denkbar

#!/bin/bash
# Aufruf: lottozahlen.sh [-S]
# mit for-Schleife, ueberpruefen auf doppelte Zufallszahlen mit while-Schleife und for-Schleife
# Feld (array) initialisieren
zahlen=(0 0 0 0 0 0)
# 6 Zufallszahlen als Lottozahlen
for k in 0 1 2 3 4 5
do
  enthalten="j"
  # solange ein neue Zufallszahl ermitteln, wie Zufallszahl schon in den Lottozahlen enthalten
  while [ $enthalten == "j" ]
  do
    let zahl=$RANDOM%49+1
    enthalten="n"
    # neue Zufallszahl $zahl in for-Schleife gegen Werte im Feld $zahlen testen
    for z in ${zahlen[*]}
    do
      if [ $zahl -eq $z ]
      then
        enthalten="j"
      fi
    done
  done
  # neue Zufallszahl gefunden, in $zahlen eintragen
  zahlen[k]=$zahl
done
echo "Lottozahlen: ${zahlen[*]}"
# Lottozahlen ausgeben, Leerzeichen durch Zeilenumbruch ersetzen, mit sort sortieren, Zeilenumbruch durch Leereeichen ersetzen
echo "Lottozahlen sortiert: `echo ${zahlen[*]} | tr " " "\n" | sort -n | tr "\n" " "`"
# Superzahl
if [ $# -eq 1 ] && [ $1 == "-S" ]
then
  let superzahl=$RANDOM%9+1
  echo "Superzahl: $superzahl"
fi
#!/bin/bash
# Aufruf: lottozahlen.sh [-S]
# mit while-Schleife, ueberpruefen auf doppelte Zufallszahlen mit while-Schleife und echo und grep
# Feld (array) initialisieren
zahlen=(0 0 0 0 0 0)
k=0
# 6 Zufallszahlen als Lottozahlen
while [ $k -lt 6 ]
do
  let zahl=$RANDOM%49+1
  while [ `echo ${zahlen[*]} | grep -c $zahl` -gt 0 ]
  do
    let zahl=$RANDOM%49+1
  done
  # neue Zufallszahl gefunden, in $zahlen eintragen
  zahlen[k]=$zahl
  let k=k+1
done
echo "Lottozahlen: ${zahlen[*]}"
# Lottozahlen ausgeben, Leerzeichen durch Zeilenumbruch ersetzen, mit sort sortieren, Zeilenumbruch durch Leereeichen ersetzen
echo "Lottozahlen sortiert: `echo ${zahlen[*]} | tr " " "\n" | sort -n | tr "\n" " "`"
# Superzahl
if [ $# -eq 1 ] && [ $1 == "-S" ]
then
  let superzahl=$RANDOM%9+1
  echo "Superzahl: $superzahl"
fi
#!/bin/bash
# Aufruf: lottozahlen.sh [-S]
# Zufallszahlen mit shuf
# shuf gibt zeilenweise aus, Zeilenumbruch durch Leerzeichen ersetzen
# Zufallsfallen als Feld (array)
zahlen=(`shuf -i 1-49 -n 6 | tr "\n" " "`)
echo "Lottozahlen: ${zahlen[*]}"
# Lottozahlen ausgeben, Leerzeichen durch Zeilenumbruch ersetzen, mit sort sortieren, Zeilenumbruch durch Leereeichen ersetzen
echo "Lottozahlen sortiert: `echo ${zahlen[*]} | tr " " "\n" | sort -n | tr "\n" " "`"
# Superzahl
if [ $# -eq 1 ] && [ $1 == "-S" ]
then
  echo "Superzahl: `shuf -i 1-9 -n 1`"
fi