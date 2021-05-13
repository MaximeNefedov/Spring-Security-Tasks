package ru.netology.springsecuritytask.services;

import lombok.val;
import org.springframework.stereotype.Service;
import ru.netology.springsecuritytask.entities.Student;
import ru.netology.springsecuritytask.entities.StudentData;
import ru.netology.springsecuritytask.repositories.StudentsRepository;
import ru.netology.springsecuritytask.repositories.UniversitiesRepository;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class StudentService {
    private final StudentsRepository studentsRepository;
    private final UniversitiesRepository universitiesRepository;

    public StudentService(StudentsRepository studentsRepository, UniversitiesRepository universitiesRepository) {
        this.studentsRepository = studentsRepository;
        this.universitiesRepository = universitiesRepository;
    }


    public Set<Student> getStudentByName(String studentName) {
        Set<Student> studentsByStudentIdName = studentsRepository.findStudentByName(studentName);
        if (studentsByStudentIdName.isEmpty()) {
            throw new IllegalArgumentException("Студент под именем " + studentName + " не найден");
        }
        return studentsByStudentIdName;
    }

    public Student saveStudent(StudentData studentData) {
        System.out.println(studentData);
        val universityName = studentData.getUniversityName();
        val university = universitiesRepository.findUniversityByName(universityName)
                .orElseThrow(
                        () -> new IllegalArgumentException("Не удалось сохранить студента: " + studentData.toString())
                );
        return studentsRepository.save(
                Student.builder()
                        .name(studentData.getFirstName())
                        .surname(studentData.getLastName())
                        .university(university)
                        .build()
        );
    }

    public void deleteStudentById(int id) {
        studentsRepository.deleteStudentById(id);
    }
}
