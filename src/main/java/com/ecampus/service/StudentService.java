package com.ecampus.service;

import com.ecampus.DTO.StudentDto;
import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.model.Lesson;
import com.ecampus.model.Student;
import com.ecampus.repository.DepartmentRepository;
import com.ecampus.repository.FacultyRepository;
import com.ecampus.repository.LessonRepository;
import com.ecampus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final FacultyRepository facultyRepository;

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Autowired
    private final LessonRepository lessonRepository;

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository, DepartmentRepository departmentRepository, LessonRepository lessonRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
        this.lessonRepository = lessonRepository;
    }



    public StudentDto addStudent(Student user) {
        Student savedStudent = studentRepository.save(user);
        return new StudentDto(
                savedStudent.getSeasonNo(),
                savedStudent.getStudentNo(),
                savedStudent.getName(),
                savedStudent.getSurname(),
                savedStudent.isGender(),
                savedStudent.getEmail(),
                savedStudent.getPhoneNo()
        );
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
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

    public Student facultyRemoveForStudentService(Long studentsId, Long facultyId) {
        Set<Faculty> facultySet=null;
        Student student=studentRepository.findById(studentsId).get();
        Faculty faculty=facultyRepository.findById(facultyId).get();
        facultySet=student.getFaculty();
        facultySet.remove(faculty);
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

    public Student departmentRemoveForStudentService(Long studentsId, Long departmentId) {
        Set<Department> departmentSet=null;
        Student student=studentRepository.findById(studentsId).get();
        Department department=departmentRepository.findById(departmentId).get();
        departmentSet=student.getDepartments();
        departmentSet.remove(department);
        student.setDepartments(departmentSet);
        return studentRepository.save(student);
    }


    public Student lessonAddForStudentService(Long studentsId, Long lessonId) {
        Set<Lesson> lessonSet=null;
        Student student=studentRepository.findById(studentsId).get();
        Lesson lesson=lessonRepository.findById(lessonId).get();
        lessonSet=student.getLessons();
        lessonSet.add(lesson);
        student.setLessons(lessonSet);
        return studentRepository.save(student);
    }

    public Student lessonRemoveForStudentService(Long studentsId, Long lessonId) {
        Set<Lesson> lessonSet=null;
        Student student=studentRepository.findById(studentsId).get();
        Lesson lesson=lessonRepository.findById(lessonId).get();
        lessonSet=student.getLessons();
        lessonSet.remove(lesson);
        student.setLessons(lessonSet);
        return studentRepository.save(student);
    }


}
