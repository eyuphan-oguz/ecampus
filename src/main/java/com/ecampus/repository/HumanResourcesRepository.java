package com.ecampus.repository;

import com.ecampus.model.Department;
import com.ecampus.model.HumanResources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanResourcesRepository extends JpaRepository<HumanResources, Long> {
}
