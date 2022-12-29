package com.ecampus.controller;

import com.ecampus.DTO.LessonDto;
import com.ecampus.model.Lesson;
import com.ecampus.model.Student;
import com.ecampus.service.LessonService;
import com.ecampus.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    //Get
    @GetMapping("/{lessonId}")
    public  LessonDto getLesson(@PathVariable Long lessonId){
        return  lessonService.getLesson(lessonId);
    }
    @PostMapping()
    public LessonDto addLesson(@RequestBody Lesson lesson)
    {
        return lessonService.addLesson(lesson);
    }
    @DeleteMapping("/{lessonId}")
    public LessonDto lessonRemove(@PathVariable Long lessonId){
        return lessonService.removeLesson(lessonId);
    }
    @GetMapping()
    public List<Lesson> getAllLessons(){
        return lessonService.getAllLessons();
    }

}
