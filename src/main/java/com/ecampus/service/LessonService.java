package com.ecampus.service;

import com.ecampus.model.Lesson;
import com.ecampus.model.Student;
import com.ecampus.repository.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    public Lesson removeLesson(Long lessonId) {
        Lesson lesson=lessonRepository.findById(lessonId).get();
        lessonRepository.delete(lesson);
        return lesson;
    }
    public Lesson getLesson(Long lessonId){
        return lessonRepository.findById(lessonId).get();
    }
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

}
