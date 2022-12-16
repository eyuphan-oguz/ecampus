package com.ecampus.service;

import com.ecampus.model.Student;
import com.ecampus.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student user) {
        this.studentRepository.save(user);
        return user;
    }
}
