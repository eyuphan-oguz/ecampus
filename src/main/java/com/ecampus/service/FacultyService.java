package com.ecampus.service;

import com.ecampus.model.Faculty;
import com.ecampus.repository.FacultyRepository;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;


    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        this.facultyRepository.save(faculty);
        return faculty;
    }
}
