package com.ecampus.DTO;

import com.ecampus.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentAffairsDto {
    private String name;
    private String surname;
    private String email;
    private String phoneNo;
    private String ibanNo;
}
