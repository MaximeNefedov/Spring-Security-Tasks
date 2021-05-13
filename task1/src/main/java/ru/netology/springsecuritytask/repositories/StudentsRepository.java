package ru.netology.springsecuritytask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.springsecuritytask.entities.Student;

import java.util.Set;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
    Set<Student> findStudentByName(String studentName);
    void deleteStudentById(int id);
}
