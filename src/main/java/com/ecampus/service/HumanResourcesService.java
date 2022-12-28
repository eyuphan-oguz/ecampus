package com.ecampus.service;

import com.ecampus.DTO.HumanResourcesDto;
import com.ecampus.model.*;
import com.ecampus.repository.DepartmentRepository;
import com.ecampus.repository.HumanResourcesRepository;
import com.ecampus.repository.StudentAffairsRepository;
import com.ecampus.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HumanResourcesService {

    private final HumanResourcesRepository humanResourcesRepository;
    private final DepartmentRepository departmentRepository;
    private final TeacherRepository teacherRepository;
    private final StudentAffairsRepository studentAffairsRepository;

    public HumanResourcesService(HumanResourcesRepository humanResourcesRepository, DepartmentRepository departmentRepository, TeacherRepository teacherRepository, StudentAffairsRepository studentAffairsRepository) {
        this.humanResourcesRepository = humanResourcesRepository;
        this.departmentRepository = departmentRepository;
        this.teacherRepository = teacherRepository;
        this.studentAffairsRepository = studentAffairsRepository;
    }

    public List<HumanResources> getAllHumanResources() {
        return humanResourcesRepository.findAll();
    }

    public HumanResources getHumanResourcesById(Long id) {
        return humanResourcesRepository.findById(id).get();
    }

    public HumanResourcesDto addHumanResources(HumanResources humanResources) {
        HumanResources savedHumanResources= humanResourcesRepository.save(humanResources);
        return new HumanResourcesDto(
                savedHumanResources.getIbanNo()
        );
    }
    public HumanResources teacherAddForHumanResources(Long teacherId, Long humanResourcesId) {
        Set<Teacher> teacherSet=null;
        HumanResources humanResources=humanResourcesRepository.findById(humanResourcesId).get();
        Teacher teacher=teacherRepository.findById(teacherId).get();
        teacherSet=humanResources.getTeacherSet();
        teacherSet.add(teacher);
        humanResources.setTeacherSet(teacherSet);
        return humanResourcesRepository.save(humanResources);
    }
    public HumanResources teacherRemoveForHumanResources(Long teacherId, Long humanResourcesId) {
        Set<Teacher> teacherSet=null;
        HumanResources humanResources=humanResourcesRepository.findById(humanResourcesId).get();
        Teacher teacher=teacherRepository.findById(teacherId).get();
        teacherSet=humanResources.getTeacherSet();
        teacherSet.remove(teacher);
        humanResources.setTeacherSet(teacherSet);
        return humanResourcesRepository.save(humanResources);
    }
    public HumanResources studentAffairsAddForHumanResources(Long studentAffairsId, Long humanResourcesId) {
        Set<StudentAffairs> studentAffairsSet = null;
        HumanResources humanResources=humanResourcesRepository.findById(humanResourcesId).get();
        StudentAffairs studentAffairs=studentAffairsRepository.findById(studentAffairsId).get();
        studentAffairsSet=humanResources.getStudentAffairsSet();
        studentAffairsSet.add(studentAffairs);
        humanResources.setStudentAffairsSet(studentAffairsSet);
        return humanResourcesRepository.save(humanResources);
    }
    public HumanResources studentAffairsRemoveForHumanResources(Long studentAffairsId, Long humanResourcesId) {
        Set<StudentAffairs> studentAffairsSet = null;
        HumanResources humanResources=humanResourcesRepository.findById(humanResourcesId).get();
        StudentAffairs studentAffairs=studentAffairsRepository.findById(studentAffairsId).get();
        studentAffairsSet=humanResources.getStudentAffairsSet();
        studentAffairsSet.remove(studentAffairs);
        humanResources.setStudentAffairsSet(studentAffairsSet);
        return humanResourcesRepository.save(humanResources);
    }
}
