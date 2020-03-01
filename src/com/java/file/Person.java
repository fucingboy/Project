package com.java.file;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description TODO
 * @Author 思绪醉流往年
 * @Date 2020/2/27 23:23
 * @Version 1.0
 **/
public class Person implements Serializable {
    public static final long serialVersionUID=47776672L;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
