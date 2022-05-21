package com.project.professor.allocation.emanuelaugusto.controller;

import com.project.professor.allocation.emanuelaugusto.entity.Department;
import com.project.professor.allocation.emanuelaugusto.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/departaments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Department>> findAll() {
        List<Department> departments = departmentService.findAll();

        return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);

    }

}
