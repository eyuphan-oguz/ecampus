package com.ecampus.controller;

import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.model.Student;
import com.ecampus.service.DepartmentService;
import com.ecampus.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyService facultyService;

    @PostMapping()
    public Faculty addFaculty(@RequestBody Faculty faculty)
    {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("/{facultyId}/departments/{departmentId}")
    public Faculty departmentAddForStudent(@PathVariable Long departmentId, @PathVariable Long facultyId){
        return facultyService.departmentAddForFacultyService(facultyId,departmentId);
    }


}
