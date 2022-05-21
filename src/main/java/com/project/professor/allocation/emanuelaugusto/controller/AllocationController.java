package com.project.professor.allocation.emanuelaugusto.controller;

import com.project.professor.allocation.emanuelaugusto.service.AllocationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.project.professor.allocation.emanuelaugusto.entity.Allocation;

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {

    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        super();
        this.allocationService = allocationService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Allocation>> findAll() {
        List<Allocation> allocations = allocationService.findAll();

        return new ResponseEntity<List<Allocation>>(allocations, HttpStatus.OK);

    }

}
