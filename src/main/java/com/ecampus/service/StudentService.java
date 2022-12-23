package com.ecampus.service;

import com.ecampus.model.Faculty;
import com.ecampus.model.Student;
import com.ecampus.repository.FacultyRepository;
import com.ecampus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final FacultyRepository facultyRepository;

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Student addStudent(Student user) {
        this.studentRepository.save(user);
        return user;
    }


    public Student facultyAddForStudentService(Long studentsId, Long facultyId) {
        Set<Faculty> facultySet=null;
        Student student=studentRepository.findById(studentsId).get();
        Faculty faculty=facultyRepository.findById(facultyId).get();
        facultySet=student.getFaculty();
        facultySet.add(faculty);
        student.setFaculty(facultySet);
        return studentRepository.save(student);
    }
}
