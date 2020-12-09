#!/bin/bash
# Program:
#   Use function to repeat information.
# History
# 2020/03/21    planning    First Release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

function printit(){
    echo -n "Your choice is "   # 加上 -n 可以不断行陆续在同一行显示
}

echo "This program will print your selection !"
case $1 in
"one")
    printit; echo $1 | tr 'a-z' 'A-Z'   # 将参数做大小写转换
    ;;
"two")
    printit; echo $1 | tr 'a-z' 'A-Z'
    ;;
"three")
    printit; echo $1 | tr 'a-z' 'A-Z'
    ;;
*)
    echo "Uasge $0 {one|two|three}"
    ;;
esac