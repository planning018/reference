#!/bin/bash
# Program:
#   Program shows the effect of shift function
# History:
# 2020/03/21    planning    First release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

echo "Total parameter number is ===> $#"
echo "Your whole parameter is ===> '$@'"
shift # 进行第一次 一个变量的 shift
echo "Total parameter number is ===> $#"
echo "Your whole parameter is ===> '$@'"
shift # 进行第二次 三个变量的 shift
echo "Total parameter number is ===> $#"
echo "Your whole parameter is ===> '$@'"