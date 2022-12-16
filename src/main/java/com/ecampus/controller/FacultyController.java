package com.ecampus.controller;

import com.ecampus.model.Faculty;
import com.ecampus.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyService facultyService;

    @PostMapping()
    public Faculty addFaculty(@RequestBody Faculty faculty)
    {
        return facultyService.addFaculty(faculty);
    }

}
