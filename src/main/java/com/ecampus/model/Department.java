package com.ecampus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private boolean facultyOrInstitute;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Faculty.class)
    @JoinTable(name = "department_student",joinColumns = @JoinColumn(name = "departmentId"),inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<Student> students=new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Lesson.class)
    @JoinTable(name = "department_lessons",joinColumns = @JoinColumn(name = "departmentId"),inverseJoinColumns = @JoinColumn(name = "lessonId"))
    private Set<Lesson> lessons=new HashSet<>();



}
