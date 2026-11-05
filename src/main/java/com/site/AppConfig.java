package com.site;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.site")
public class AppConfig {

    @Bean
    public Address address() {
        Address address = new Address();
        address.setCity("Addis Ababa");
        address.setCountry("Ethiopia");
        return address;
    }

    @Bean
    public Subject math() {
        Subject subject = new Subject();
        subject.setSubjectName("Maths 101");
        return subject;
    }

    @Bean
    public Subject java() {
        Subject subject = new Subject();
        subject.setSubjectName("Java EE");
        return subject;
    }
}
