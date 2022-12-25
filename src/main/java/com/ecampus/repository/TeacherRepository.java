package com.ecampus.repository;

import com.ecampus.model.Student;
import com.ecampus.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
}
