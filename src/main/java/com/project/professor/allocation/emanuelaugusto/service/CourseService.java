package com.project.professor.allocation.emanuelaugusto.service;

import org.springframework.stereotype.Service;
import com.project.professor.allocation.emanuelaugusto.repository.AllocationRepository;
import com.project.professor.allocation.emanuelaugusto.repository.CourseRepository;
import com.project.professor.allocation.emanuelaugusto.entity.Course;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final AllocationRepository allocationRepository;

    public CourseService(CourseRepository courseRepository, AllocationRepository allocationRepository) {
        super();
        this.courseRepository = courseRepository;
        this.allocationRepository = allocationRepository;
    }

    public Course findById(Long id){
        Course course  = courseRepository.findById(id).orElse(null);

        return course; 
    }


    public List<Course> findAll(){
        List<Course> courses = courseRepository.findAll();

        return courses;
    }

    public Course saveOrUpdate(Course course){
      Course courseCreateOrUpdate = courseRepository.save(course);

      return courseCreateOrUpdate;
    }

    public void deleteById(Long id){
        
        courseRepository.deleteById(id);
    }
}