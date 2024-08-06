#!/bin/bash

# schreiben einer Funktion

function add {
    echo $(($#+1))
    echo $@
}

# aufrufen der Funktion

echo "hier das Ergebnis der Funktion" 
add

# aufrufen der Funktion inkl Parameter 2

echo "hier das Ergebnis der Funktion und dem Parameter 2" 
add 2 3 4




