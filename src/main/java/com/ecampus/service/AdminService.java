package com.ecampus.service;

import com.ecampus.model.Admin;
import com.ecampus.model.Department;
import com.ecampus.model.HumanResources;
import com.ecampus.repository.*;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;

    public AdminService (DepartmentRepository departmentRepository,
                         FacultyRepository facultyRepository,
                         AdminRepository adminRepository)
    {
        this.adminRepository = adminRepository;
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Admin getAdminById(Long adminId){return adminRepository.findById(adminId).get();}

}
