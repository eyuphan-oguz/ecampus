package com.ecampus.controller;


import com.ecampus.DTO.StudentDto;
import com.ecampus.model.Department;
import com.ecampus.model.Student;
import com.ecampus.repository.StudentRepository;
import com.ecampus.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping()
    public StudentDto addUser(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @PutMapping("/{studentId}/faculties/{facultyId}")
    public Student facultyAddForStudent(@PathVariable Long studentId,@PathVariable Long facultyId){
        return studentService.facultyAddForStudentService(studentId,facultyId);
    }

    @PutMapping("/{studentId}/departments/{departmentId}")
    public Student departmentAddForStudent(@PathVariable Long studentId,@PathVariable Long departmentId){
        return studentService.departmentAddForStudentService(studentId,departmentId);
    }

    @PutMapping("/{studentId}/lessons/{lessonId}")
    public Student lessonAddForStudent(@PathVariable Long studentId,@PathVariable Long lessonId){
        return studentService.lessonAddForStudentService(studentId,lessonId);
    }

    @DeleteMapping("/{studentId}/faculties/{facultyId}")
    public Student facultyDeleteForStudent(@PathVariable Long studentId,@PathVariable Long facultyId){
        return studentService.facultyRemoveForStudentService(studentId,facultyId);
    }

    @DeleteMapping("/{studentId}/departments/{departmentId}")
    public Student departmentDeleteForStudent(@PathVariable Long studentId,@PathVariable Long departmentId){
        return studentService.departmentRemoveForStudentService(studentId,departmentId);
    }

    @DeleteMapping("/{studentId}/lessons/{lessonId}")
    public Student lessonDeleteForStudent(@PathVariable Long studentId,@PathVariable Long lessonId){
        return studentService.lessonRemoveForStudentService(studentId,lessonId);
    }
}
