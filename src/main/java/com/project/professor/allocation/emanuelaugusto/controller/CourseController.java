package com.project.professor.allocation.emanuelaugusto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.professor.allocation.emanuelaugusto.entity.Course;
import java.util.List;
import com.project.professor.allocation.emanuelaugusto.service.CourseService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        super();
        this.courseService = courseService;

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Course>> findAll(@RequestParam(name = "name", required = false) String name) {
        List<Course> courses = courseService.findAll(name);
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }

}
