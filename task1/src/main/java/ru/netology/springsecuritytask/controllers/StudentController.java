package ru.netology.springsecuritytask.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springsecuritytask.entities.Student;
import ru.netology.springsecuritytask.services.StudentService;

import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Set<Student> getStudentByName(@RequestParam("name") String studentName) {
        return studentService.getStudentByName(studentName);
    }
}
