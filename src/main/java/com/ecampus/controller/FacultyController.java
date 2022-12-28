package com.ecampus.controller;

import com.ecampus.DTO.FacultyDto;
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
    public List<Faculty> getAllFaculty(){
        return facultyService.getAllFaculty();
    }
    @GetMapping("/{facultyId}")
    public Faculty getFaculty(@PathVariable Long facultyId){
        return facultyService.getFacultyById(facultyId);
    }

    @PostMapping()
    public FacultyDto addFaculty(@RequestBody Faculty faculty)
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
    public FacultyDto facultyRemove(@PathVariable Long facultyId){
        return facultyService.removeFaculty(facultyId);
    }


}
