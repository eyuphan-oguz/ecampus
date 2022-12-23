package com.ecampus.service;

import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.model.Student;
import com.ecampus.repository.DepartmentRepository;
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

    @Autowired
    private final DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
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

    public Student departmentAddForStudentService(Long studentsId, Long departmentId) {
        Set<Department> departmentSet=null;
        Student student=studentRepository.findById(studentsId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=student.getDepartments();
        departmentSet.add(department);
        student.setDepartments(departmentSet);
        return studentRepository.save(student);
    }
}
