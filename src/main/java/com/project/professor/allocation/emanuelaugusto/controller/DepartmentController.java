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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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

    @DeleteMapping(path = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeacher(@PathVariable(name = "departmentId") Long departmentId) {
        departmentService.deleteById(departmentId);
    }

    @ApiOperation(value = "Create one department")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OK")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity save(@RequestBody Department department) {
        department = departmentService.saveOrUpdate(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Find a department by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping(path = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Department> findById(@PathVariable(name = "departmentId") Long id) {
        Department department = departmentService.findById(id);
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(department, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Update one department")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OK")
    })
    @PutMapping(path = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity update(@PathVariable(name = "departmentId") Long id, @RequestBody Department department) {
        department.setId(id);
        department = departmentService.saveOrUpdate(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

}
