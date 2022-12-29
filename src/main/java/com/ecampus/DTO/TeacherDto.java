package com.ecampus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherDto {
    private String name;
    private String surname;
    private String email;
    private boolean gender;
    private String phoneNo;
    private String ibanNo;
}
