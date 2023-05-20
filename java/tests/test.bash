#!/bin/bash

# Fonction qui tester un programme while
# $1 : chemin du programme while
# $2 : resultat attendu
# $3 : numero du test
function test
{

    local path=$1
    local Res=$(bash runner.bash $path)
    
    if [ $Res = $2 ]
    then
        echo "Test $3  : OK"
    else
        echo "Test $3 : KO"
    fi

}

path="programmes_test"

# Test des programmes while
test "$path/shouldWorks_AppelleFonction.while" "2" "1"
test "$path/shouldWorks_AppelleFonctionSansArgument.while" "1" "2"
test "$path/shouldWorks_BasiqueMain.while" "0" "3"
test "$path/shouldWorks_BasiqueMainAvecConsImbrique.while" "2" "4"
test "$path/shouldWorks_BasiqueMainAvecString.while" "ab" "5"
test "$path/shouldWorks_BasiqueMainAvecString2.while" "helloworld" "6"