package com.project.professor.allocation.emanuelaugusto.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.util.List;

@Entity
@Table(name = "departament")
public class Departament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	// @OneToMany(mappedBy = "departament")
	// private List<Teacher> teachers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public List<Teacher> getTeachers() {
	// return teachers;
	// }

	// public void setTeachers(List<Teacher> teachers) {
	// this.teachers = teachers;
	// }

}
