#!bin/bash
# Program:
#   User input a filename, program will check the following
#   1. exist?  2. file / directory?  3. file permissions
# History:
# 2020/03/20    planning    First release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

# 1. 让使用者输入 档案名称，并且校验使用者是否真的有输入字符串？
echo -e "please input a filename, I will check the filename's type and \
permission. \n\n"
read -p "input a filename: " filename
test -z $filename && echo "You must input a filename." && exit 0

# 2. 判断档案是否存在？ 若不存在，则提示信息并结束脚本
test ! -e $filename && echo "The filename '$filename' DO NOT exist" && exit 0

# 3. 开始判断文件类型和属性
test -f $filename && filetype="regular file"
test -d $filename && filetype="directory"
test -r $filename && perm="readable"
test -w $filename && perm="$perm writable"
test -x $filename && perm="$perm executable"

# 4. 开始输出信息
echo "The filename: $filename is a $filetype"
echo "And the permissions are : $perm"