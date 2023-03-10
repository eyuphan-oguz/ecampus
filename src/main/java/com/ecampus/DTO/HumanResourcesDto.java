package com.ecampus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HumanResourcesDto {
    private String name;
    private String surname;
    private String email;
    private String phoneNo;
    private String ibanNo;
}
