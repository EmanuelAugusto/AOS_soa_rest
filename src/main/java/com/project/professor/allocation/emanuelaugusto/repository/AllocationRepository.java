package com.project.professor.allocation.emanuelaugusto.repository;

import com.project.professor.allocation.emanuelaugusto.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

    List<Allocation> findByTeacherId(Long professorId);

    List<Allocation> findByCourseId(Long courseId);

    @Query(value = "SELECT * FROM allocation a WHERE a.day = :day AND a.start >= :start AND a.end <= :end AND a.teacher_id = :teacherId", nativeQuery = true)
    List<Allocation> findConflict(@Param("day") String day, @Param("start") String start, @Param("end") String end,
            @Param("teacherId") Long teacherId);
}