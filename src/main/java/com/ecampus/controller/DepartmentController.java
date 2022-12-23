package com.ecampus.controller;

import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.service.DepartmentService;
import com.ecampus.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping()
    public Department addDepartment(@RequestBody Department department)
    {
        return departmentService.addDepartment(department);
    }



}
