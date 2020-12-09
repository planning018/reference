#!/bin/bash
# Program:
#   Use id, finger command to check system account's infomation.
# History
# 2020/03/21    planning    first release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

users=$(cut -d ':' -f1 /etc/passwd)  # 开始获取账号名称
for username in $users      # 开始循环进行 ！
do
    id $username
    finger $username
done