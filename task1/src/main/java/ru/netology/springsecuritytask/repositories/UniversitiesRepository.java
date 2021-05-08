package ru.netology.springsecuritytask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.springsecuritytask.entities.University;

import java.util.Optional;

public interface UniversitiesRepository extends JpaRepository<University, Integer> {
    Optional<University> findUniversityByName(String universityName);
}
