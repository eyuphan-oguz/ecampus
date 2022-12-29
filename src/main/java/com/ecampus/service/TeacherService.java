package com.ecampus.service;
import com.ecampus.DTO.TeacherDto;
import com.ecampus.model.*;
import com.ecampus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecampus.model.Lesson;
import com.ecampus.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TeacherService {

    @Autowired
    private final TeacherRepository teacherRepository;
    @Autowired
    private final FacultyRepository facultyRepository;
    @Autowired
    private final DepartmentRepository departmentRepository;
    @Autowired
    private  final LessonRepository lessonRepository;

    public TeacherService(TeacherRepository teacherRepository, FacultyRepository facultyRepository, DepartmentRepository departmentRepository, LessonRepository lessonRepository) {
        this.teacherRepository = teacherRepository;
        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
        this.lessonRepository = lessonRepository;
    }
    public TeacherDto addTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        return new TeacherDto(
                savedTeacher.getName(),
                savedTeacher.getSurname(),
                savedTeacher.getEmail(),
                savedTeacher.isGender(),
                savedTeacher.getPhoneNo(),
                savedTeacher.getIbanNo()
        );
    }
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
    public TeacherDto getTeacherById(Long id) {
        Teacher getTeacherById = teacherRepository.findById(id).get();
        return new TeacherDto(
                getTeacherById.getName(),
                getTeacherById.getSurname(),
                getTeacherById.getEmail(),
                getTeacherById.isGender(),
                getTeacherById.getPhoneNo(),
                getTeacherById.getIbanNo()
        );
    }
    public Teacher facultyAddForTeacherService(Long teacherId, Long facultyId) {
        Set<Faculty> facultySet=null;
        Teacher teacher=teacherRepository.findById(teacherId).get();
        Faculty faculty=facultyRepository.findById(facultyId).get();
        facultySet=teacher.getFaculty();
        facultySet.add(faculty);
        teacher.setFaculty(facultySet);
        return teacherRepository.save(teacher);
    }
    public Teacher facultyRemoveForTeacherService(Long teacherId, Long facultyId) {
        Set<Faculty> facultySet=null;
        Teacher teacher=teacherRepository.findById(teacherId).get();
        Faculty faculty=facultyRepository.findById(facultyId).get();
        facultySet=teacher.getFaculty();
        facultySet.remove(faculty);
        teacher.setFaculty(facultySet);
        return teacherRepository.save(teacher);
    }

    public Teacher departmentAddForTeacherService(Long teacherId, Long departmentId) {
        Set<Department> departmentSet=null;
        Teacher teacher=teacherRepository.findById(teacherId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=teacher.getDepartments();
        departmentSet.add(department);
        teacher.setDepartments(departmentSet);
        return teacherRepository.save(teacher);
    }
    public Teacher departmentRemoveForTeacherService(Long teacherId, Long departmentId) {
        Set<Department> departmentSet=null;
        Teacher teacher=teacherRepository.findById(teacherId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=teacher.getDepartments();
        departmentSet.remove(department);
        teacher.setDepartments(departmentSet);
        return teacherRepository.save(teacher);
    }
    public Teacher lessonAddForTeacherService(Long teacherId, Long lessonId) {
        Set<Lesson> lessonSet=null;
        Teacher teacher=teacherRepository.findById(teacherId).get();
        Lesson lesson=lessonRepository.findById(lessonId).get();
        lessonSet=teacher.getLessons();
        lessonSet.add(lesson);
        teacher.setLessons(lessonSet);
        return teacherRepository.save(teacher);
    }

    public Teacher lessonRemoveForTeacherService(Long teacherId, Long lessonId) {
        Set<Lesson> lessonSet=null;
        Teacher teacher=teacherRepository.findById(teacherId).get();
        Lesson lesson=lessonRepository.findById(lessonId).get();
        lessonSet=teacher.getLessons();
        lessonSet.remove(lesson);
        teacher.setLessons(lessonSet);
        return teacherRepository.save(teacher);
    }
}
