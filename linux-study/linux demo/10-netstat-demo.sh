#!/bin/bash
# Program:
#   Using netstat and grep to detect WWW,SSH,FTP and Mail service
# History:
# 2020/03/21    planning    First release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

# 1. 先作一些告知的动作
echo "Now, I will detect your Linux server's services!"
echo -e "The www. ftp, ssh, and mail will be detect! \n"

# 2. 开始进行一些测试的工作，并且也输出一些信息
testing=$(netstat -tuln | grep ":80 ")   # 检查 port 80 在否
if [ "$testing" != "" ]; then
    echo "WWW is running in your system."
fi
testing=$(netstat -tuln | grep ":22")   # 检查 port 22 在否
if [ "$testing" != "" ]; then
    echo "SSH is running in your system."
fi
testing=$(netstat -tuln | grep ":21 ")    # 检查 port 21 在否
if [ "$testing" != "" ]; then
    echo "FTP is running in your system."
fi
testing=$(netstat -tuln | grep ":25 ")    # 检查 port 25 在否
if [ "$testing" != "" ]; then
    echo "Mail is running in your system."
fi