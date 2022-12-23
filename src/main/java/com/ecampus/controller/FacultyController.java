package com.ecampus.controller;

import com.ecampus.model.Faculty;
import com.ecampus.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    //@GetMapping(path = "/students")

}
