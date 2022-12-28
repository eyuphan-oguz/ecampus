package com.ecampus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDto {
    private String departmentName;
    private boolean facultyOrInstitute;
}
