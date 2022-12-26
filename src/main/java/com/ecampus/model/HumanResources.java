package com.ecampus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HumanResources extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ibanNo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = StudentAffairs.class)
    @JoinTable(name = "humanResources_studentAffairsId",joinColumns = @JoinColumn(name = "humanResourcesId"),inverseJoinColumns = @JoinColumn(name = "studentAffairsId"))
    private Set<StudentAffairs> studentAffairsSet=new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Teacher.class)
    @JoinTable(name = "humanResources_teacher",joinColumns = @JoinColumn(name = "humanResources"),inverseJoinColumns = @JoinColumn(name = "teacherId"))
    private Set<Teacher> teacherSet=new HashSet<>();

}
