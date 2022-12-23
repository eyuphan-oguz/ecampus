package com.ecampus.service;

import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.model.Student;
import com.ecampus.repository.DepartmentRepository;
import com.ecampus.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;

    public DepartmentService(DepartmentRepository departmentRepository, FacultyRepository facultyRepository) {
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
    }


    public Department addDepartment(Department department) {
        this.departmentRepository.save(department);
        return department;
    }

    public Department removeDepartment(Long departmentId) {
        Department department=departmentRepository.findById(departmentId).get();
        departmentRepository.delete(department);
        return department;
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }






}
