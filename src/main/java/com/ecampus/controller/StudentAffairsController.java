package com.ecampus.controller;

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
    public StudentAffairs getStudentAffairs(@PathVariable Long studentAffairsId){
        return studentAffairsService.getStudentAffairsById(studentAffairsId);
    }

    @PostMapping()
    public StudentAffairs addStudentAffairs(@RequestBody StudentAffairs studentAffairs)
    {
        return studentAffairsService.addStudentAffairs(studentAffairs);
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
