package com.project.professor.allocation.emanuelaugusto.controller;

import com.project.professor.allocation.emanuelaugusto.service.TeacherService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.professor.allocation.emanuelaugusto.entity.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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

    @DeleteMapping(path = "/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeacher(@PathVariable(name = "teacherId") Long teacherId) {
        teacherService.deleteById(teacherId);
    }

    @ApiOperation(value = "Create one teacher")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OK")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity save(@RequestBody Teacher teacher) {
        teacher = teacherService.saveOrUpdate(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Find a teacher by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping(path = "/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Teacher> findById(@PathVariable(name = "teacherId") Long id) {
        Teacher teacher = teacherService.findById(id);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Update one teacher")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OK")
    })
    @PutMapping(path = "/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity update(@PathVariable(name = "teacherId") Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        teacher = teacherService.saveOrUpdate(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

}
