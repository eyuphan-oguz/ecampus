package com.ecampus.service;

import com.ecampus.DTO.LessonDto;
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

    public LessonDto addLesson(Lesson lesson) {
        Lesson savedLesson = lessonRepository.save(lesson);
        return new LessonDto(
                savedLesson.getLessonName(),
                savedLesson.getCredit()
        );
    }
    public LessonDto removeLesson(Long lessonId) {
        Lesson savedLesson = lessonRepository.findById(lessonId).get();
        lessonRepository.delete(savedLesson);
        return new LessonDto(savedLesson.getLessonName(),savedLesson.getCredit());
    }
    public LessonDto getLesson(Long lessonId){
        Lesson savedLesson = lessonRepository.findById(lessonId).get();
        return new LessonDto(
                savedLesson.getLessonName(),
                savedLesson.getCredit()
        );
    }
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

}
