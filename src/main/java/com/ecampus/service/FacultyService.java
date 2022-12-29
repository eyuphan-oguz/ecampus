package com.ecampus.service;

import com.ecampus.DTO.FacultyDto;
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

    public FacultyDto addFaculty(Faculty faculty) {
        Faculty savedFaculty = facultyRepository.save(faculty);
        return new FacultyDto(
                savedFaculty.getFacultyName(),
                savedFaculty.getFacultyManagerName()
        );
    }

    public FacultyDto removeFaculty(Long facultyId) {
        Faculty savedFaculty=facultyRepository.findById(facultyId).get();
        facultyRepository.delete(savedFaculty);
        return new FacultyDto(
                savedFaculty.getFacultyName(),
                savedFaculty.getFacultyManagerName()
        );
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

    public FacultyDto getFacultyById(Long id) {
        Faculty getFacultyById = facultyRepository.findById(id).get();
        return new FacultyDto(
                getFacultyById.getFacultyName(),
                getFacultyById.getFacultyManagerName()
        );
    }

}
