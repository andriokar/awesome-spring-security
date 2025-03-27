package com.andriokar.security.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = List.of(
            new Student(1, "Frodo Baggins"),
            new Student(2, "Sam Gamgee"),
            new Student(3, "Pippin Took"),
            new Student(4, "Merry Brandybuck")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student with id: %d was not found".formatted(studentId)));
    }
}
