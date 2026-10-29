package com.site;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main( String[] args )
    {
        //tight coupling
        // Student student = new Student();
        //student.getHello();

        ApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml");
        Student student = context.getBean("student", Student.class);


        /*
        student.setId(101);
        student.setName("John");
        student.setAge(34);
        */

        //student.getHello();
        //student.getDetails();
        System.out.println("Student Name: " + student.getName());
        System.out.println(student);
    }

}