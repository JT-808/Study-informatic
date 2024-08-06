#!bin/bash

echo "Anzahl der an das Skript übergebenen Parameter: " $#
echo '$1: ' $1
echo '$2: ' $2
echo '$3: ' $3
echo '$4: ' $4
echo '$5: ' $5

echo "-------------"
echo $# $1 $2 $3
set $1 xxxxx $3
echo $# $1 $2 $3
set otto hugo bert
echo $# $1 $2 $3
