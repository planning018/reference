package com.planning.tool;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.planning.bean.Person;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;

import java.util.HashMap;

/**
 * compare two objects of same class and check what fields diff
 */
public class ObjectsCompare {

    public static void main(String[] args) {
        Person p1 = new Person("001","zhangsan");
        Person p2 = new Person("002","lisi");

        // use third-party jar : javers
        Javers javers = JaversBuilder.javers().build();
        Diff diff = javers.compare(p1, p2);
        /*
            ValueChange{ 'personId' value changed from '001' to '002' }
            ValueChange{ 'name' value changed from 'zhangsan' to 'lisi' }
         */
        diff.getChanges().forEach(System.out::println);

        // use HashMap
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap map1 = objectMapper.convertValue(p1, HashMap.class);
        HashMap map2 = objectMapper.convertValue(p2, HashMap.class);
        // todo I can't find a easy way to compare two hashMap key&values different

    }
}
