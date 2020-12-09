package com.planning.bean;

import lombok.Data;

import java.util.List;

/**
 * Person class
 * @author planning
 */
@Data
public class Person {

    private String personId;
    private String name;

    private List<Person> personList;

    private List<String> blackName;

    public Person(){}

    public Person(String personId, String name){
        this.personId = personId;
        this.name = name;
    }
}
