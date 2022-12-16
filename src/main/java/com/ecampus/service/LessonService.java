package com.ecampus.service;

import com.ecampus.model.Lesson;
import com.ecampus.model.Student;
import com.ecampus.repository.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson addLesson(Lesson lesson) {
        this.lessonRepository.save(lesson);
        return lesson;
    }
}
