package com.project.professor.allocation.emanuelaugusto.service;

import com.project.professor.allocation.emanuelaugusto.repository.AllocationRepository;
import com.project.professor.allocation.emanuelaugusto.repository.DepartmentRepository;
import com.project.professor.allocation.emanuelaugusto.repository.TeacherRepository;

import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;
    private final AllocationRepository allocationRepository;

    public TeacherService(TeacherRepository teacherRepository, DepartmentRepository departmentRepository,
            AllocationRepository allocationRepository) {
        super();
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
        this.allocationRepository = allocationRepository;
    }

}
