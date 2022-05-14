package com.project.professor.allocation.emanuelaugusto.service;

import org.springframework.stereotype.Service;
import com.project.professor.allocation.emanuelaugusto.repository.CourseRepository;

@Service
public class CouresService {

    private final CourseRepository courseRepository;

    public CouresService(CourseRepository courseRepository) {
        super();
        this.courseRepository = courseRepository;
    }
}
