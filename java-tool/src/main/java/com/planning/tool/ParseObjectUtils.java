package com.planning.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.planning.bean.Person;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 对象转换
 *
 * @author yxc
 * @date 2021/3/8 17:06
 */
public class ParseObjectUtils {

    private final static TypeReference DRIVER_RECALL_RESULT_TYPE_REFERENCE = new TypeReference<List<Person>>() {};

    public static void main(String[] args) {
        parseListObject();
    }

    private static void parseListObject(){
        List<Person> personList = Lists.newArrayList();
        IntStream.range(0,4).forEach(i -> {
            Person person = new Person(String.valueOf(i), "zhangsan" + i);
            personList.add(person);
        });

        String personStr = JSON.toJSONString(personList);
        List<Person> personParseList = JSON.parseObject(personStr, new TypeReference<List<Person>>() {
        });
        System.out.println(personParseList);
    }
}
