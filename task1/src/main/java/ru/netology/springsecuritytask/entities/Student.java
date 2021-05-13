package ru.netology.springsecuritytask.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@EqualsAndHashCode(exclude = "university")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "university_id")
    private University university;
}
