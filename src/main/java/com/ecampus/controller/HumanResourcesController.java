package com.ecampus.controller;

import com.ecampus.model.HumanResources;
import com.ecampus.model.StudentAffairs;
import com.ecampus.model.Teacher;
import com.ecampus.repository.HumanResourcesRepository;
import com.ecampus.service.HumanResourcesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/humanResources")
@RequiredArgsConstructor
public class HumanResourcesController {

    private final HumanResourcesService humanResourcesService;


    @GetMapping()
    public List<HumanResources> getAllHumanResources(){
        return humanResourcesService.getAllHumanResources();
    }

    @GetMapping("/{humanResourcesId}")
    public HumanResources getHumanResources(@PathVariable Long humanResourcesId){
        return humanResourcesService.getHumanResourcesById(humanResourcesId);
    }

    @PostMapping()
    public HumanResources addHumanResources(@RequestBody HumanResources humanResources)
    {
        return humanResourcesService.addHumanResources(humanResources);
    }

    @PutMapping("/{humanResourcesId}/teacher/{teacherId}")
    public HumanResources teacherAddForHumanResources(@PathVariable Long humanResourcesId, @PathVariable Long teacherId){
        return humanResourcesService.teacherAddForHumanResources(teacherId,humanResourcesId);
    }

    @DeleteMapping("/{humanResourcesId}/teacher/{teacherId}")
    public HumanResources teacherRemoveForHumanResources(@PathVariable Long humanResourcesId, @PathVariable Long teacherId){
        return humanResourcesService.teacherRemoveForHumanResources(teacherId,humanResourcesId);
    }
}
