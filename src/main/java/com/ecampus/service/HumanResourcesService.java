package com.ecampus.service;

import com.ecampus.model.Department;
import com.ecampus.model.Faculty;
import com.ecampus.model.HumanResources;
import com.ecampus.model.Student;
import com.ecampus.repository.HumanResourcesRepository;
import com.ecampus.repository.StudentAffairsRepository;
import com.ecampus.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HumanResourcesService {

    private final HumanResourcesRepository humanResourcesRepository;
    private final TeacherRepository teacherRepository;
    private final StudentAffairsRepository studentAffairsRepository;

    public HumanResourcesService(HumanResourcesRepository humanResourcesRepository, TeacherRepository teacherRepository, StudentAffairsRepository studentAffairsRepository) {
        this.humanResourcesRepository = humanResourcesRepository;
        this.teacherRepository = teacherRepository;
        this.studentAffairsRepository = studentAffairsRepository;
    }

    public List<HumanResources> getAllHumanResources() {
        return humanResourcesRepository.findAll();
    }

    public HumanResources getHumanResourcesById(Long id) {
        return humanResourcesRepository.findById(id).get();
    }



    public HumanResources addHumanResources(HumanResources humanResources) {
        this.humanResourcesRepository.save(humanResources);
        return humanResources;
    }


}
