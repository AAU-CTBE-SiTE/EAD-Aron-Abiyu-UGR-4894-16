
package com.site.studentmanagement.controller;

import com.site.studentmanagement.dto.StudentDTO;
import com.site.studentmanagement.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    // Constructor injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public StudentDTO createStudent(
            @Valid @RequestBody StudentDTO studentDTO) {

        return studentService.saveStudent(studentDTO);
    }

    // READ ALL
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public StudentDTO updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDTO studentDTO) {

        return studentService.updateStudent(id, studentDTO);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
