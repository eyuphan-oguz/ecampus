package com.ecampus.service;

import com.ecampus.DTO.StudentAffairsDto;
import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.model.StudentAffairs;
import com.ecampus.repository.DepartmentRepository;
import com.ecampus.repository.FacultyRepository;
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

    @Autowired
    private final FacultyRepository facultyRepository;

    public StudentAffairsService(StudentAffairsRepository studentAffairsRepository, DepartmentRepository departmentRepository, FacultyRepository facultyRepository) {
        this.studentAffairsRepository = studentAffairsRepository;
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
    }

    public List<StudentAffairs> getAllStudentAffairs() {
        return studentAffairsRepository.findAll();
    }

    public StudentAffairsDto getStudentAffairsById(Long id) {
        StudentAffairs getStudentAffairsById = studentAffairsRepository.findById(id).get();
        return new StudentAffairsDto(
                getStudentAffairsById.getName(),
                getStudentAffairsById.getSurname(),
                getStudentAffairsById.getEmail(),
                getStudentAffairsById.getPhoneNo(),
                getStudentAffairsById.getIbanNo()
        );
    }

    public StudentAffairsDto addStudentAffairs(StudentAffairs studentAffairs) {
        StudentAffairs savedStudentAffairs = studentAffairsRepository.save(studentAffairs);
        return new StudentAffairsDto(
                savedStudentAffairs.getName(),
                savedStudentAffairs.getSurname(),
                savedStudentAffairs.getEmail(),
                savedStudentAffairs.getPhoneNo(),
                savedStudentAffairs.getIbanNo()
        );
    }

    public StudentAffairs facultyAddForStudentAffairs(Long studentAffairsId, Long facultyId) {
        StudentAffairs studentAffairs = studentAffairsRepository.findById(studentAffairsId).get();
        Faculty faculty = facultyRepository.findById(facultyId).get();
        studentAffairs.setFaculty(faculty);
        return studentAffairsRepository.save(studentAffairs);
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
