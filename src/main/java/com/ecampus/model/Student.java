package com.ecampus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//entity koyma sebebimiz ayri bir tablo olacagini soylemek
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int seasonNo;
    private String studentNo;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Faculty.class)
    @JoinTable(name = "student_faculty",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "facultyId"))
    private Set<Faculty> faculty=new HashSet<>();
    private boolean studentType;

}
