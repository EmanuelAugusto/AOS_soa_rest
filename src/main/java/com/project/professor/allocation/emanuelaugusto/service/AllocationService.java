package com.project.professor.allocation.emanuelaugusto.service;

import com.project.professor.allocation.emanuelaugusto.repository.AllocationRepository;
import com.project.professor.allocation.emanuelaugusto.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.project.professor.allocation.emanuelaugusto.entity.Allocation;

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

	public List<Allocation> findAll() {
		List<Allocation> allocations = this.allocationRepository.findAll();

		return allocations;
	}

	public Allocation findById(Long id) {
		Allocation allocation = this.allocationRepository.findById(id).orElse(null);

		return allocation;
	}

	public Allocation save(Allocation allocation) {

		Allocation allocationSave = allocationRepository.save(allocation);

		return allocationSave;
	}

	public void deleteById(Long id) {
		allocationRepository.deleteById(id);
	}

}
