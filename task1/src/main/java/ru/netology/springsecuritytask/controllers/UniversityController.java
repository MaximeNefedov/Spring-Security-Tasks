package ru.netology.springsecuritytask.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.netology.springsecuritytask.entities.Student;
import ru.netology.springsecuritytask.entities.University;
import ru.netology.springsecuritytask.services.UniversityService;

import javax.annotation.security.RolesAllowed;
import java.util.Set;

@RestController
@RequestMapping("/university")
public class UniversityController {
    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/get-info")
    @RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
    public University getUniversityByName(@RequestParam("name") String universityName) {
        return universityService.getUniversityByName(universityName);
    }

    @GetMapping("/get-all-students")
    @RolesAllowed("ROLE_ADMIN")
    public Set<Student> getAllStudentsFromUniversity(@RequestParam("name") String universityName) {
        return universityService.getAllStudentsFromUniversity(universityName);
    }

    @GetMapping("/get-number-of-students")
    @Secured("READ")
    public String getNumberOfStudentsAtTheUniversity(@RequestParam("name") String universityName) {
        return String.format(
                "Количество студентов в университете %s : %d",
                universityName, universityService.getNumberOfStudentsAtTheUniversity(universityName)
        );
    }

    @GetMapping("/get-info-for-all")
    public String getInfo() {
        return "Эту информацию могут видеть неаутентифицированные пользователи";
    }
}
