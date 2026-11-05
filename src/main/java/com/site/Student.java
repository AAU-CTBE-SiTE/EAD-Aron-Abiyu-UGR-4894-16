package com.site;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ToString
@Component
public class Student {

    private int id;
    private String name;
    private int age;

    private Address address;
    private List<Subject> subjects;

    @Autowired
    public Student(Address address, List<Subject> subjects) {
        this.id = 101;
        this.name = "Belachew";
        this.age = 20;
        this.address = address;
        this.subjects = subjects;
    }

    public void getDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Address: " + address);

        for (Subject subject : subjects) {
            System.out.println("Subject: " + subject.getSubjectName());
        }
    }
}