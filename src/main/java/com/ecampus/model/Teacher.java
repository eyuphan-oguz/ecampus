package com.ecampus.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ibanNo;
    @ManyToMany
    private List<Student> studentList;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Faculty.class)
    @JoinTable(name = "teacher_faculty",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "facultyId"))
    private Set<Faculty> faculty=new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Department.class)
    @JoinTable(name = "teacher_department",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "departmentId"))
    private Set<Department> departments=new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Lesson.class)
    @JoinTable(name = "teacher_lessons",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "lessonId"))
    private Set<Lesson> lessons=new HashSet<>();
}