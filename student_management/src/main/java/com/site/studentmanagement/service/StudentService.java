
package com.site.studentmanagement.service;

import com.site.studentmanagement.dto.StudentDTO;
import com.site.studentmanagement.model.Student;
import com.site.studentmanagement.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Convert Student Entity into StudentDTO
    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getDepartment()
        );
    }

    // Convert StudentDTO into Student Entity
    private Student convertToEntity(StudentDTO dto) {
        Student student = new Student();

        student.setId(dto.getId());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setDepartment(dto.getDepartment());

        return student;
    }

    // CREATE
    public StudentDTO saveStudent(StudentDTO dto) {
        Student student = convertToEntity(dto);

        Student savedStudent = studentRepository.save(student);

        return convertToDTO(savedStudent);
    }

    // READ ALL
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // READ BY ID
    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // UPDATE
    public StudentDTO updateStudent(Long id, StudentDTO dto) {

        Student existingStudent =
                studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setFirstName(dto.getFirstName());
        existingStudent.setLastName(dto.getLastName());
        existingStudent.setEmail(dto.getEmail());
        existingStudent.setDepartment(dto.getDepartment());

        Student updatedStudent =
                studentRepository.save(existingStudent);

        return convertToDTO(updatedStudent);
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
