#!/bin/bash

# Rechne eingangsparameter mal 2

echo $(($1 * 2))


#Fließkommazahlen

echo $(echo "scale=2; $length*$width*$height" | bc)
echo $1*$2*$3 | bc   
# bc führt eine Berechnung mit Fließkommazahlen durch, indem sie eine mathematische Ausdruckszeichenfolge an bc übergibt. 
# Die scale=2 definiert die Anzahl der Dezimalstellen, die in der Ausgabe angezeigt werden sollen.
