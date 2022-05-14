package com.project.professor.allocation.emanuelaugusto.service;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.emanuelaugusto.repository.AllocationRepository;
import com.project.professor.allocation.emanuelaugusto.repository.CourseRepository;

@Service
public class CouresService {

    private final CourseRepository courseRepository;
    private final AllocationRepository allocationRepository;

    public CouresService(CourseRepository courseRepository, AllocationRepository allocationRepository) {
        super();
        this.courseRepository = courseRepository;
        this.allocationRepository = allocationRepository;
    }
}
