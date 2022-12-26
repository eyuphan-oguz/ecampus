package com.ecampus.service;

import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.repository.DepartmentRepository;
import com.ecampus.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final DepartmentRepository departmentRepository;


    public FacultyService(FacultyRepository facultyRepository, DepartmentRepository departmentRepository) {
        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        this.facultyRepository.save(faculty);
        return faculty;
    }

    public Faculty removeFaculty(Long facultyId) {
        Faculty faculty=facultyRepository.findById(facultyId).get();
        facultyRepository.delete(faculty);
        return faculty;
    }

    public Faculty departmentAddForFacultyService(Long departmentId, Long facultyId) {
        Set<Department> departmentSet=null;
        Faculty faculty=facultyRepository.findById(facultyId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=faculty.getDepartments();
        departmentSet.add(department);
        faculty.setDepartments(departmentSet);
        return facultyRepository.save(faculty);
    }

    public Faculty departmentRemoveForFacultyService(Long departmentId, Long facultyId) {
        Set<Department> departmentSet=null;
        Faculty faculty=facultyRepository.findById(facultyId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=faculty.getDepartments();
        departmentSet.remove(department);
        faculty.setDepartments(departmentSet);
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).get();
    }

}
