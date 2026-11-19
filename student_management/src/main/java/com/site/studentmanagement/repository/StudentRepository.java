package com.site.studentmanagement.repository;


import com.site.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

}

