#!/bin/bash
# Program:
#   Show "Hello" from $1... by using case ... esac
# History:
# 2020/03/21    planning    First Release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

case $1 in
"hello")
    echo "Hello, how are you ?"
    ;;
"")
    echo "You MUST input parameters, ex> {$0 someword}"
    ;;
*)  # 其实就相当于通配符
    echo "Uasge $0 {hello}"
    ;;
esac