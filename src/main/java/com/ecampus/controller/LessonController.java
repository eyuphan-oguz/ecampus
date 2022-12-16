package com.ecampus.controller;

import com.ecampus.model.Lesson;
import com.ecampus.model.Student;
import com.ecampus.service.LessonService;
import com.ecampus.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping()
    public Lesson addLesson(@RequestBody Lesson lesson)
    {
        return lessonService.addLesson(lesson);
    }
}
