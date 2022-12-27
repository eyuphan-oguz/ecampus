package com.ecampus.repository;

import com.ecampus.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
