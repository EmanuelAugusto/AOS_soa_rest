package com.project.professor.allocation.emanuelaugusto.service;

import com.project.professor.allocation.emanuelaugusto.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import com.project.professor.allocation.emanuelaugusto.entity.Teacher;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        super();
        this.teacherRepository = teacherRepository;
    }

    public Teacher findById(Long id) {
        Teacher course = teacherRepository.findById(id).orElse(null);

        return course;
    }

    public List<Teacher> findAll() {
        List<Teacher> courses = teacherRepository.findAll();

        return courses;
    }

    public Teacher saveOrUpdate(Teacher course) {
        Teacher courseCreateOrUpdate = teacherRepository.save(course);

        return courseCreateOrUpdate;
    }

    public void deleteById(Long id) {

        teacherRepository.deleteById(id);
    }

}
