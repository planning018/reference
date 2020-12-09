#!/bin/bash
# Program
#	User inputs his first name and last name. Program show his full name
# History:
# 2020/03/11  planning	First release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

read -p "please input your first name: " firstname #提示使用者输入
read -p "please input your last name:"  lastname  #提示使用者输入
echo -e "\nYour full name is $firstname $lastname" #结果由屏幕输出

