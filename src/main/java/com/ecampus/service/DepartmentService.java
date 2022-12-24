package com.ecampus.service;

import com.ecampus.model.Department;
import com.ecampus.model.Lesson;
import com.ecampus.repository.DepartmentRepository;
import com.ecampus.repository.FacultyRepository;
import com.ecampus.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    @Autowired
    private final LessonRepository lessonRepository;

    public DepartmentService(DepartmentRepository departmentRepository, FacultyRepository facultyRepository, LessonRepository lessonRepository) {
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
        this.lessonRepository = lessonRepository;
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


    public Department lessonAddForDepartmentService(Long lessonId, Long departmentId) {
        Set<Lesson> lessonSet=null;
        Department department=departmentRepository.findById(departmentId).get();
        Lesson lesson=lessonRepository.findById(lessonId).get();
        lessonSet=department.getLessons();
        lessonSet.add(lesson);
        department.setLessons(lessonSet);
        return departmentRepository.save(department);
    }


    public Department lessonRemoveForDepartmentService(Long lessonId, Long departmentId) {
        Set<Lesson> lessonSet=null;
        Department department=departmentRepository.findById(departmentId).get();
        Lesson lesson=lessonRepository.findById(lessonId).get();
        lessonSet=department.getLessons();
        lessonSet.remove(lesson);
        department.setLessons(lessonSet);
        return departmentRepository.save(department);
    }






}
