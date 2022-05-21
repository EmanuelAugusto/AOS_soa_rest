package com.project.professor.allocation.emanuelaugusto.service;

import com.project.professor.allocation.emanuelaugusto.repository.AllocationRepository;
import com.project.professor.allocation.emanuelaugusto.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import com.project.professor.allocation.emanuelaugusto.entity.Teacher;
import java.util.List;
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherRepository departmentRepository;
    private final AllocationRepository allocationRepository;

    public TeacherService(TeacherRepository teacherRepository, TeacherRepository departmentRepository,
            AllocationRepository allocationRepository) {
        super();
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
        this.allocationRepository = allocationRepository;
    }

    public Teacher findById(Long id) {
        Teacher course = departmentRepository.findById(id).orElse(null);

        return course;
    }

    public List<Teacher> findAll() {
        List<Teacher> courses = departmentRepository.findAll();

        return courses;
    }

    public Teacher saveOrUpdate(Teacher course) {
        Teacher courseCreateOrUpdate = departmentRepository.save(course);

        return courseCreateOrUpdate;
    }

    public void deleteById(Long id) {

        departmentRepository.deleteById(id);
    }

}
