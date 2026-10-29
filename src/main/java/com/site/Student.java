package com.site

import lombok.Data;
import lombok.ToString;
import sun.jvm.hotspot.debugger.Address;

@Data
@ToString

public class Student {
    private int id;
    private String name;
    private int age;
    private Address address;

    public Student(int id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address=address;
        System.out.println("Student Parameterized Constructor Called");
    }

    public void getHello() {
        System.out.println("Hello Springers");
    }
    public void getDetails() {
        System.out.println("Student Details " + this);
    }

}