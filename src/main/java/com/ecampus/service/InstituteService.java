package com.ecampus.service;

import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.model.Institute;
import com.ecampus.repository.DepartmentRepository;
import com.ecampus.repository.InstituteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class InstituteService {
    private final InstituteRepository instituteRepository;
    private final DepartmentRepository departmentRepository;

    public InstituteService(InstituteRepository instituteRepository, DepartmentRepository departmentRepository) {
        this.instituteRepository = instituteRepository;
        this.departmentRepository = departmentRepository;
    }

    public Institute addInstitute(Institute institute) {
        this.instituteRepository.save(institute);
        return institute;
    }

    public Institute removeInstitute(Long instituteId) {
        Institute institute=instituteRepository.findById(instituteId).get();
        instituteRepository.delete(institute);
        return institute;
    }

    public Institute departmentAddForInstituteService(Long departmentId, Long instituteId) {
        Set<Department> departmentSet=null;
        Institute institute=instituteRepository.findById(instituteId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=institute.getDepartments();
        departmentSet.add(department);
        institute.setDepartments(departmentSet);
        return instituteRepository.save(institute);
    }

    public Institute departmentRemoveForInstituteService(Long departmentId, Long instituteId) {
        Set<Department> departmentSet=null;
        Institute institute=instituteRepository.findById(instituteId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=institute.getDepartments();
        departmentSet.remove(department);
        institute.setDepartments(departmentSet);
        return instituteRepository.save(institute);
    }

    public List<Institute> getAllInstitutes() {
        return instituteRepository.findAll();
    }

    public Institute getInstituteById(Long id) {
        return instituteRepository.findById(id).get();
    }

}
