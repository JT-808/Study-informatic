#!/bin/sh

# - Substitution
echo ${var1:-"text"}
var1=etwas
echo ${var1:-"text"}


# = Substitution ( ähnlich wie die - Substituion)
echo ${var2:="zweiter text"}
var2="was anderes"
echo ${var2:="zweiter text"}

# echo ${var3:?"text"} -> es kommt fehlermeldung , script wird abgebrochen!!
var3=sonstwas
echo ${var3:?"text"}

# + Substitution
echo ${var4:+"wert"}  # es kommt nichts zurück, weil Leer
var4=irgendwas
echo ${var4:+"text"}

t1=hallo
HELP=abc
echo $t1
echo ${t1} Rest
echo ${t1- "nicht"}
echo ${t2- "nicht"}
echo ${t2-$HELP}
echo ${t2+$HELP}  # es kommt nichts, weil leer und das + interessiert danach nicht ( erst wenn t2 belegt ist)



