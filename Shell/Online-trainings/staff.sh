#!/bin/bash

datei=./Test.txt



case $1 in

-m)
# zeige alle Personen an die ein "M" in der 3. Spalte haben

result=$(awk '$3 == "m"' "$datei")
echo $result

;;

-b)


;;

*)
echo nicht erlaubt
exit 1
esac