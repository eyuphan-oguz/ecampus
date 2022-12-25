package com.ecampus.service;

import com.ecampus.model.Department;
import com.ecampus.model.StudentAffairs;
import com.ecampus.repository.DepartmentRepository;
import com.ecampus.repository.StudentAffairsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentAffairsService {

    @Autowired
    private final StudentAffairsRepository studentAffairsRepository;

    @Autowired
    private final DepartmentRepository departmentRepository;

    public StudentAffairsService(StudentAffairsRepository studentAffairsRepository, DepartmentRepository departmentRepository) {
        this.studentAffairsRepository = studentAffairsRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<StudentAffairs> getAllStudentAffairs() {
        return studentAffairsRepository.findAll();
    }

    public StudentAffairs getStudentAffairsById(Long id) {
        return studentAffairsRepository.findById(id).get();
    }


    public StudentAffairs addStudentAffairs(StudentAffairs studentAffairs) {
        this.studentAffairsRepository.save(studentAffairs);
        return studentAffairs;
    }


    public StudentAffairs departmentAddForStudentAffairsService(Long studentAffairsId, Long departmentId) {
        Set<Department> departmentSet=null;
        StudentAffairs studentAffairs=studentAffairsRepository.findById(studentAffairsId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=studentAffairs.getDepartments();
        departmentSet.add(department);
        studentAffairs.setDepartments(departmentSet);
        return studentAffairsRepository.save(studentAffairs);
    }

    public StudentAffairs departmentRemoveForStudentAffairsService(Long studentAffairsId, Long departmentId) {
        Set<Department> departmentSet=null;
        StudentAffairs studentAffairs=studentAffairsRepository.findById(studentAffairsId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=studentAffairs.getDepartments();
        departmentSet.remove(department);
        studentAffairs.setDepartments(departmentSet);
        return studentAffairsRepository.save(studentAffairs);
    }
}
