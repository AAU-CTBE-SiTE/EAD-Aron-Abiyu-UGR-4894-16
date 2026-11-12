package site.example.lab6.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    // Getters and Setters
    private Long id;
    private String name;
    private String course;

    // Constructors
    public Student() {}
    public Student(Long id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

}