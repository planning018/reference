#!/bin/bash
# Program:
#   This program shows the user's choice
# History
# 2020/03/21    planning    First release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

# demo 1
# read -p "please input (Y/N): " yn

# if [ "$yn" == "Y" ] || [ "$yn" == "y" ]; then
#     echo "OK, continue"
# elif [ "$yn" == "N" ] || [ "$yn" == "n" ]; then
#     echo "Oh, interrupt!"
# else
#     echo "I don't know what your choice is"
# fi

if [ "$1" == "hello" ]; then
    echo "Hello, how are you ?"
elif [ "$1" == "" ]; then
    echo "You must input parameters, ex> {$0 someword}"
else 
    echo "The only parameters is 'hello', ex> {$0 hello}"
fi