package com.ecampus.controller;

import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.model.Student;
import com.ecampus.service.DepartmentService;
import com.ecampus.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyService facultyService;

    @GetMapping()
    public List<Faculty> getFaculty(){
        return facultyService.getAllFaculty();
    }

    @PostMapping()
    public Faculty addFaculty(@RequestBody Faculty faculty)
    {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("/{facultyId}/departments/{departmentId}")
    public Faculty departmentAddForStudent(@PathVariable Long departmentId, @PathVariable Long facultyId){
        return facultyService.departmentAddForFacultyService(facultyId,departmentId);
    }

    @DeleteMapping("/{facultyId}/departments/{departmentId}")
    public Faculty departmentRemoveForStudent(@PathVariable Long departmentId, @PathVariable Long facultyId){
        return facultyService.departmentRemoveForFacultyService(facultyId,departmentId);
    }

    @DeleteMapping("/{facultyId}")
    public Faculty facultyRemove(@PathVariable Long facultyId){
        return facultyService.removeFaculty(facultyId);
    }


}
