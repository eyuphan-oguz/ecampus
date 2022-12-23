package com.ecampus.repository;

import com.ecampus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface StudentRepository  extends JpaRepository<Student, Long> {
}
