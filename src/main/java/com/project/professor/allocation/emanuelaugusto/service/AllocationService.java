package com.project.professor.allocation.emanuelaugusto.service;

import com.project.professor.allocation.emanuelaugusto.repository.AllocationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.text.SimpleDateFormat;
import com.project.professor.allocation.emanuelaugusto.entity.Allocation;
import com.project.professor.allocation.emanuelaugusto.Exception.ExceptionConflictHours;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;
	// private final CourseRepository courseRepository;
	// private final TeacherService teacherService;

	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
		// this.courseRepository = courseRepository;
		// this.teacherService = teacherService;
	}

	public List<Allocation> findAll() {
		List<Allocation> allocations = this.allocationRepository.findAll();

		return allocations;
	}

	public Allocation findById(Long id) {
		Allocation allocation = this.allocationRepository.findById(id).orElse(null);

		return allocation;
	}

	private Boolean checkConflictOfAllocation(Allocation allocation) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		List<Allocation> allocationget = allocationRepository.findConflict(allocation.getDay().toString(),
				sdf.format(allocation.getStart().getTime()), sdf.format(allocation.getEnd().getTime()),
				allocation.getTeacherId());

		if (allocationget.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public Allocation save(Allocation allocation) throws Exception {

		System.out.println(allocation.toString());
		System.out.println("\n");
		Boolean canSave = checkConflictOfAllocation(allocation);

		if (canSave) {
			Allocation allocationSave = allocationRepository.save(allocation);

			return allocationSave;
		} else {
			throw new Exception("time_conflict");
		}

	}

	public void deleteById(Long id) {
		allocationRepository.deleteById(id);
	}

}
