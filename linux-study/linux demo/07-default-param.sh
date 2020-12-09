#!/bin/bash
# Program:
#   Program shows the script name, parameters...
# History:
# 2020/03/20  planning  First release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

echo "The script name is  ===> $0"
echo "Total parameter number is  ===> $#"
["$#" -lt 2] && echo "The number of parameter is less than 2. stop here." && exit 0
echo "Your whole parameter is ===> '$@'"
echo "The 1st parameter    ===> $1"
echo "The 2st parameter    ===> $2"