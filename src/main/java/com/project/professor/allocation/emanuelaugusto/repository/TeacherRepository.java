package com.project.professor.allocation.emanuelaugusto.repository;

import com.project.professor.allocation.emanuelaugusto.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByNameContainingIgnoreCase(String name);

    List<Teacher> findByDepartmentId(Long departmentId);
}