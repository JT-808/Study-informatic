#!bin/bash
echo insert Coin
read Zahl
x=$(($Zahl + 3))
echo "you payed: $Zahl" and won $x

echo now?

# Möglichkeit 2

options="Run Exit"
# Es entsteht eine Auswahl mit 1.) Run und 2.) Exit
select options in $options; do
    if [ "Run" = $options ]; then
            clear
            exit
        elif [ $options = "Exit" ]; then
            echo Exiting now
            exit
        else echo error
    fi
done

# ob "Run" = $option oder $option = "run" ist egal
# nach einer do schleife kommt done