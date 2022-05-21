package com.project.professor.allocation.emanuelaugusto.controller;

import com.project.professor.allocation.emanuelaugusto.service.TeacherService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.professor.allocation.emanuelaugusto.entity.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

@RestController
@RequestMapping(path = "/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        super();

        this.teacherService = teacherService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Teacher>> findAll() {
        List<Teacher> teachers = teacherService.findAll();

        return new ResponseEntity<List<Teacher>>(teachers, HttpStatus.OK);

    }

}
