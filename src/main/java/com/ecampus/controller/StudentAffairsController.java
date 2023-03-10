package com.ecampus.controller;

import com.ecampus.DTO.StudentAffairsDto;
import com.ecampus.model.Student;
import com.ecampus.model.StudentAffairs;
import com.ecampus.service.StudentAffairsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentAffairs")
@RequiredArgsConstructor
public class StudentAffairsController {

    private final StudentAffairsService studentAffairsService;

    @GetMapping()
    public List<StudentAffairs> getAllStudent(){
        return studentAffairsService.getAllStudentAffairs();
    }

    @GetMapping("/{studentAffairsId}")
    public StudentAffairsDto getStudentAffairs(@PathVariable Long studentAffairsId){
        return studentAffairsService.getStudentAffairsById(studentAffairsId);
    }

    @PostMapping()
    public StudentAffairsDto addStudentAffairs(@RequestBody StudentAffairs studentAffairs)
    {
        return studentAffairsService.addStudentAffairs(studentAffairs);
    }

    @PutMapping("/{studentAffairsId}/faculty/{facultyId}")
    public StudentAffairs facultyAddForStudent(@PathVariable Long studentAffairsId,@PathVariable Long facultyId){
        return studentAffairsService.facultyAddForStudentAffairs(studentAffairsId,facultyId);
    }

    @PutMapping("/{studentAffairsId}/departments/{departmentId}")
    public StudentAffairs departmentAddForStudent(@PathVariable Long studentAffairsId,@PathVariable Long departmentId){
        return studentAffairsService.departmentAddForStudentAffairsService(studentAffairsId,departmentId);
    }

    @DeleteMapping("/{studentAffairsId}/departments/{departmentId}")
    public StudentAffairs departmentDeleteForStudentAffairs(@PathVariable Long studentAffairsId,@PathVariable Long departmentId){
        return studentAffairsService.departmentRemoveForStudentAffairsService(studentAffairsId,departmentId);
    }


}
