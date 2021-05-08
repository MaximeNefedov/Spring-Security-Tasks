package ru.netology.springsecuritytask.entities;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@EqualsAndHashCode(exclude = "university")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "students")
public class Student {
    @EmbeddedId
    private StudentId studentId;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "university_id")
    private University university;
}
