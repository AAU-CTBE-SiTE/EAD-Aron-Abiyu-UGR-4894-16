package site.example.lab6.service;

import site.example.lab6.exception.StudentNotFoundException;
import site.example.lab6.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    // In-memory "database"
    private final Map<Long, Student> studentDb = new HashMap<>();
    private Long currentId = 1L;

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDb.values());
    }

    public Student addStudent(Student student) {
        student.setId(currentId++);
        studentDb.put(student.getId(), student);
        return student;
    }

    public Student getStudentById(Long id) {
        Student student = studentDb.get(id);
        if (student == null) {
            // This will trigger our ExceptionAspect!
            throw new StudentNotFoundException("Student with ID " + id + " not found!");
        }
        return student;
    }
}