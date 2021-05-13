package ru.netology.springsecuritytask.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.netology.springsecuritytask.entities.Student;
import ru.netology.springsecuritytask.entities.StudentData;
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
    @PreAuthorize("hasRole('ADMIN') or #studentName == authentication.principal.username")
    public Set<Student> getStudentByName(@RequestParam("name") String studentName) {
        return studentService.getStudentByName(studentName);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('WRITE', 'DELETE')")
    public Student saveStudent(@RequestBody StudentData studentData) {
        return studentService.saveStudent(studentData);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('WRITE', 'DELETE')")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudentById(id);
    }
}
