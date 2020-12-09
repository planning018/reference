#!/bin/bash
# Program:
#   User inputs 2 Integer numbers; Program will do some math operation.
# History:
# 2020/03/20    planning    first version
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH
echo -e "You should input 2 Integer numbers, I will add them! \n"
read -p "first number: " firstNumber
read -p "second number: " secondNumber
sum=$(($firstNumber+$secondNumber))
echo -e "\nThe result of $firstNumber + $secondNumber is ====> $sum"