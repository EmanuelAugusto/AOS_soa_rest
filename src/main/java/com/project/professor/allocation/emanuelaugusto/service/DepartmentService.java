package com.project.professor.allocation.emanuelaugusto.service;

import com.project.professor.allocation.emanuelaugusto.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import com.project.professor.allocation.emanuelaugusto.entity.Department;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    // private final TeacherRepository teacherRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
        // this.teacherRepository = teacherRepository;
    }

    public Department findById(Long id) {
        Department course = departmentRepository.findById(id).orElse(null);

        return course;
    }

    public List<Department> findAll() {
        List<Department> courses = departmentRepository.findAll();

        return courses;
    }

    public Department saveOrUpdate(Department course) {
        Department courseCreateOrUpdate = departmentRepository.save(course);

        return courseCreateOrUpdate;
    }

    public void deleteById(Long id) {

        departmentRepository.deleteById(id);
    }

}
