package com.ecampus.repository;

import com.ecampus.model.StudentAffairs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAffairsRepository extends JpaRepository<StudentAffairs, Long> {
}
