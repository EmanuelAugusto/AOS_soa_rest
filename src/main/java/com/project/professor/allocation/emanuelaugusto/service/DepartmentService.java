package com.project.professor.allocation.emanuelaugusto.service;

import com.project.professor.allocation.emanuelaugusto.repository.DepartmentRepository;
import com.project.professor.allocation.emanuelaugusto.repository.TeacherRepository;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final TeacherRepository teacherRepository;

    public DepartmentService(DepartmentRepository departmentRepository, TeacherRepository teacherRepository) {
        super();
        this.departmentRepository = departmentRepository;
        this.teacherRepository = teacherRepository;
    }

}
