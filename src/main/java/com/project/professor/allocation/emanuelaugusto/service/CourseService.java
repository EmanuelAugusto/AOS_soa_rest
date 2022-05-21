package com.project.professor.allocation.emanuelaugusto.service;

import org.springframework.stereotype.Service;
import com.project.professor.allocation.emanuelaugusto.repository.CourseRepository;
import com.project.professor.allocation.emanuelaugusto.entity.Course;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    // private final AllocationRepository allocationRepository;

    public CourseService(CourseRepository courseRepository) {
        super();
        this.courseRepository = courseRepository;
        // this.allocationRepository = allocationRepository;
    }

    public Course findById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);

        return course;
    }

    public List<Course> findAll(String name) {

        if (name == null) {
            List<Course> courses = courseRepository.findAll();
            return courses;

        } else {
            List<Course> courses = courseRepository.findByNameContainingIgnoreCase(name);
            return courses;
        }

    }

    public Course saveOrUpdate(Course course) {
        Course courseCreateOrUpdate = courseRepository.save(course);

        return courseCreateOrUpdate;
    }

    public void deleteById(Long id) {

        courseRepository.deleteById(id);
    }
}
