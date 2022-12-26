package com.ecampus.controller;

import com.ecampus.model.Faculty;
import com.ecampus.model.Institute;
import com.ecampus.service.FacultyService;
import com.ecampus.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituties")
@RequiredArgsConstructor
public class InstituteController {
    private final InstituteService instituteService;

    @GetMapping()
    public List<Institute> getAllInstitute(){
        return instituteService.getAllInstitute();
    }
    @GetMapping("/{instituteId}")
    public Institute getInstituteById(@PathVariable Long instituteId){return instituteService.getInstituteById(instituteId);}

    @PostMapping()
    public Institute addInstitute(@RequestBody Institute institute)
    {
        return instituteService.addInstitute(institute);
    }

    @PutMapping("/{instituteID}/departments/{departmentId}")
    public Institute departmentAddForStudent(@PathVariable Long departmentId, @PathVariable Long instituteID){
        return instituteService.departmentAddForInstituteService(instituteID,departmentId);
    }

    @DeleteMapping("/{instituteId}/departments/{departmentId}")
    public Institute departmentRemoveForStudent(@PathVariable Long departmentId, @PathVariable Long instituteId){
        return instituteService.departmentRemoveForInstituteService(instituteId,departmentId);
    }

    @DeleteMapping("/{instituteId}")
    public Institute instituteRemove(@PathVariable Long instituteId){
        return instituteService.removeInstitute(instituteId);
    }
}
