#!/bin/bash
# Program:
#   This program shows the user's choice
# History
# 2020/03/20    planning    First release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

read -p "Please input (Y/N): " yn
[ "$yn" == "Y" -o "$yn" == "y" ] && echo "OK, continue" && exit 0
[ "$yn" == "N" -o "$yn" == "n" ] && echo "Oh, Inteerupt" && exit 0
echo "I don't know what your choice is" && exit 0