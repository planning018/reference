#!/bin/bash
# Program:
#   This program shows the user's choice
# History
# 2020/03/21    planning    First release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

read -p "please input (Y/N): " yn

if [ "$yn" == "Y" ] || [ "$yn" == "y" ]; then
    echo "OK, continue"
    exit 0
fi
if [ "$yn" == "N" ] || [ "$yn" == "n" ]; then
    echo "Oh, interrupt!"
    exit 0
fi 
echo "I don't know what your choice is" && exit 0