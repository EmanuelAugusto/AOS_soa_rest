package com.project.professor.allocation.emanuelaugusto.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	@Column(name = "departmentId", nullable = false)
	private Long departmentId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "departmentId", nullable = false, insertable = false, updatable = false)
	private Departament department;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Departament getDepartment() {
		return department;
	}

	public void setDepartment(Departament department) {
		this.department = department;
	}
}
