package com.ecampus.controller;

import com.ecampus.model.Student;
import com.ecampus.model.Teacher;
import com.ecampus.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping()
    public Teacher addTeacher(@RequestBody Teacher teacher)
    {
        return teacherService.addTeacher(teacher);
    }
    @GetMapping()
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeacher();
    }
    @GetMapping("/{teacherId}")
    public Teacher getTeacher(@PathVariable Long teacherId){
        return teacherService.getTeacherById(teacherId);
    }

    @PutMapping("/{teacherId}/faculties/{facultyId}")
    public Teacher facultyAddForTeacher(@PathVariable Long teacherId,@PathVariable Long facultyId){
        return teacherService.facultyAddForTeacherService(teacherId,facultyId);
    }

    @PutMapping("/{teacherId}/departments/{departmentId}")
    public Teacher departmentAddForTeacher(@PathVariable Long teacherId,@PathVariable Long departmentId){
        return teacherService.departmentAddForTeacherService(teacherId,departmentId);
    }

    @PutMapping("/{teacherId}/lessons/{lessonId}")
    public Teacher lessonAddForTeacher(@PathVariable Long teacherId,@PathVariable Long lessonId){
        return teacherService.lessonAddForTeacherService(teacherId,lessonId);
    }

    @DeleteMapping("/{teacherId}/faculties/{facultyId}")
    public Teacher facultyDeleteForTeacher(@PathVariable Long teacherId,@PathVariable Long facultyId){
        return teacherService.facultyRemoveForTeacherService(teacherId,facultyId);
    }

    @DeleteMapping("/{teacherId}/departments/{departmentId}")
    public Teacher departmentDeleteForTeacher(@PathVariable Long teacherId,@PathVariable Long departmentId){
        return teacherService.departmentRemoveForTeacherService(teacherId,departmentId);
    }

    @DeleteMapping("/{teacherId}/lessons/{lessonId}")
    public Teacher lessonDeleteForTeacher(@PathVariable Long teacherId,@PathVariable Long lessonId){
        return teacherService.lessonRemoveForTeacherService(teacherId,lessonId);
    }

}
