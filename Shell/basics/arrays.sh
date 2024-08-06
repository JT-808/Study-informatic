#!/bin/bash

# arrays können verschiedene Datentypen beinhalten (in shell)

# arrays beschriften


array[0]=10
array[1]=11
array[2]=12
#-----------

#aufrufen eines arrays immer mit ${}

echo ${array[0]}

array2=()
array3=(10 11 12 13 14 "ende")

# alle Elemente eines Arrays wiedergeben

echo ${array3[*]}
echo ${array3[@]}



