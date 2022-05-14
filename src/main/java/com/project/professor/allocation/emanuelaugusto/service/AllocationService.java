package com.project.professor.allocation.emanuelaugusto.service;

import com.project.professor.allocation.emanuelaugusto.repository.AllocationRepository;
import com.project.professor.allocation.emanuelaugusto.repository.CourseRepository;

import org.springframework.stereotype.Service;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;
	private final CourseRepository courseRepository;
	private final TeacherService teacherService;

	public AllocationService(AllocationRepository allocationRepository, CourseRepository courseRepository,
			TeacherService teacherService) {
		super();
		this.allocationRepository = allocationRepository;
		this.courseRepository = courseRepository;
		this.teacherService = teacherService;
	}

}
