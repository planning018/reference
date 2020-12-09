#!/bin/bash
# Program:
#   Repeat question until input correct answer.
# History:
# 2020/03/21    planning    First Release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

# while [ "$yn" != "yes" -a "$yn" != "YES" ]
# do
#     read -p "Please input yes/YES to stop this program: " yn
# done
# echo "OK! you input the correct answer."

# until [ "$yn" == "yes" -o "$yn" == "YES" ]
# do
#     read -p "Please input yes/YES to stop this program: " yn
# done
# echo "OK! you input the correct answer."

s=0 # sum 总数
i=0
while [ "$i" != "100" ]
do
    i=$(($i+1))    # 每次 i 都会增加 1
    s=$(($s+$i))   # 每次都会加总一次!
done
echo "The result of '1+2+3+....+100' is ===> $s"