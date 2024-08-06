#!/bin/bash
x=22
y=122
echo $((x + y))


if [ $x = 12 ]; then
    echo x ist 12
     elif [ $x = 3 ]; then
        echo x = 3
else 
    echo x ist nicht 12
fi

# elif = Else if()

echo ---------

#Wieviele Benutzer sind angemeldet? -> Größer als 5?


if [ $(who | wc -l) -gt 5 ]
then
echo  "angemeldet"
else 
echo "weniger als 5"
fi

echo -----
# Namen lesen in A speichern und ausgeben
if [ $# -eq 0 ]
then
    echo  -n " Bitte Namen eingeben: "
    read A
else 
A="leer"
fi
echo $A