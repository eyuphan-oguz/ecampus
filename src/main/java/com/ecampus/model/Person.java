package com.ecampus.model;


import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Person {
    private String name;
    private String surname;
    private Date birthDate;
    private String tcNo;
    private Date registerDate;
    private String city;
    private boolean gender;
    private String motherName;
    private String fatherName;
    private String birthPlace;
    private String email;
    private String phoneNo;
    private LocalDateTime createDate = LocalDateTime.now();
}
