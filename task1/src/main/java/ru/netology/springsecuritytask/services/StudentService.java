package ru.netology.springsecuritytask.services;

import org.springframework.stereotype.Service;
import ru.netology.springsecuritytask.entities.Student;
import ru.netology.springsecuritytask.repositories.StudentsRepository;

import java.util.Set;

@Service
public class StudentService {
    private final StudentsRepository studentsRepository;

    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Set<Student> getStudentByName(String studentName) {
        Set<Student> studentsByStudentIdName = studentsRepository.findStudentByStudentIdName(studentName);
        if (studentsByStudentIdName.isEmpty()) {
            throw new IllegalArgumentException("Студент под именем " + studentName + " не найден");
        }
        return studentsByStudentIdName;
    }
}
