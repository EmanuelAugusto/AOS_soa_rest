package com.project.professor.allocation.emanuelaugusto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.project.professor.allocation.emanuelaugusto.entity.Allocation;
import com.project.professor.allocation.emanuelaugusto.service.AllocationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.project.professor.allocation.emanuelaugusto.Exception.ExceptionConflictHours;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {

    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        super();
        this.allocationService = allocationService;
    }

    @ApiOperation(value = "Find all allocations")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Allocation>> findAll() {
        List<Allocation> allocations = allocationService.findAll();

        return new ResponseEntity<List<Allocation>>(allocations, HttpStatus.OK);

    }

    @ApiOperation(value = "Find an allocation by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping(path = "/{allocation_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Allocation> findById(@PathVariable(name = "allocation_id") Long id) {
        Allocation allocation = allocationService.findById(id);
        if (allocation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(allocation, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Create one allocation")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity save(@RequestBody Allocation allocation) {
        try {
            allocation = allocationService.save(allocation);
            return new ResponseEntity<>(allocation, HttpStatus.CREATED);
        } catch (Exception e) {

            ExceptionConflictHours exception = new ExceptionConflictHours();
            exception.setMessage(e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
        }
    }

    @ApiOperation(value = "Update one allocation")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OK")
    })
    @PutMapping(path = "/{allocationId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity update(@PathVariable(name = "allocationId") Long id, @RequestBody Allocation allocation) {
        try {
            allocation.setId(id);
            allocation = allocationService.save(allocation);
            return new ResponseEntity<>(allocation, HttpStatus.CREATED);
        } catch (Exception e) {

            ExceptionConflictHours exception = new ExceptionConflictHours();
            exception.setMessage(e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
        }
    }

    @DeleteMapping(path = "/{allocationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "allocationId") Long allocationId) {
        allocationService.deleteById(allocationId);
    }

}
