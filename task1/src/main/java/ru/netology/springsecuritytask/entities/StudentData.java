package ru.netology.springsecuritytask.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentData {
    private final String firstName;
    private final String lastName;
    private final String universityName;
}
