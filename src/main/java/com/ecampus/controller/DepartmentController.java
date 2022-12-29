package com.ecampus.controller;

import com.ecampus.DTO.DepartmentDto;
import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.model.Student;
import com.ecampus.service.DepartmentService;
import com.ecampus.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping()
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{departmentId}")
    public DepartmentDto getDepartment(@PathVariable Long departmentId){
        DepartmentDto savedDepartment = departmentService.getDepartmentById(departmentId);
        return new DepartmentDto(
          savedDepartment.getDepartmentName(),
          savedDepartment.isFacultyOrInstitute()
        );
    }

    @PostMapping()
    public DepartmentDto addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @DeleteMapping("/{departmentId}")
    public DepartmentDto departmentRemove(@PathVariable Long departmentId){
        return departmentService.removeDepartment(departmentId);
    }

    @PutMapping("/{departmentId}/lessons/{lessonId}")
    public Department lessonAddForDepartment(@PathVariable Long departmentId, @PathVariable Long lessonId){
        return departmentService.lessonAddForDepartmentService(departmentId,lessonId);
    }

    @DeleteMapping("/{departmentId}/lessons/{lessonId}")
    public Department lessonRemoveForDepartment(@PathVariable Long departmentId, @PathVariable Long lessonId){
        return departmentService.lessonRemoveForDepartmentService(departmentId,lessonId);
    }


}
