#!/bin/bash
# Program:
#   Parse Json data
# History
# 2020/05/12    yxc    first release
PATH=usr/java/default/bin:/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/java/default/bin:/root/bin
export PATH

#JQ_EXEC=`where jq`
filePath=product-stevedore.json

count=`cat $filePath | jq '.hits.total.value'`

echo -e "\033[33m-------------------------------parse start--------------------------------------\033[0m"

for ((i=0;i<$count;i++))
do
  indexId=`cat $filePath | jq -c ".hits.hits[$i]._id"`
  tempValue=`cat $filePath | jq -c ".hits.hits[$i]._source"`
  echo {"index":{"_id":$indexId}}
  echo $tempValue
done


echo -e "\033[33m-------------------------------parse end---------------------------------------\033[0m"











