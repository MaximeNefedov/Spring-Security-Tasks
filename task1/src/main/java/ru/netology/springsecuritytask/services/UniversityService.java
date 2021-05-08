package ru.netology.springsecuritytask.services;

import lombok.val;
import org.springframework.stereotype.Service;
import ru.netology.springsecuritytask.entities.Student;
import ru.netology.springsecuritytask.entities.University;
import ru.netology.springsecuritytask.repositories.UniversitiesRepository;

import java.util.Set;

@Service
public class UniversityService {
    private final UniversitiesRepository universitiesRepository;

    public UniversityService(UniversitiesRepository universitiesRepository) {
        this.universitiesRepository = universitiesRepository;
    }

    public University getUniversityByName(String universityName) {
        return universitiesRepository.findUniversityByName(universityName).orElseThrow(
                () -> new IllegalArgumentException("Университет под именем " + universityName + " не найден")
        );
    }

    public Set<Student> getAllStudentsFromUniversity(String universityName) {
        val university = universitiesRepository.findUniversityByName(universityName).orElseThrow(
                () -> new IllegalArgumentException("Университет под именем " + universityName + " не найден")
        );
        return university.getStudents();
    }

    public int getNumberOfStudentsAtTheUniversity(String universityName) {
        val university = universitiesRepository.findUniversityByName(universityName).orElseThrow(
                () -> new IllegalArgumentException("Университет под именем " + universityName + " не найден")
        );
        return university.getStudents().size();
    }
}
