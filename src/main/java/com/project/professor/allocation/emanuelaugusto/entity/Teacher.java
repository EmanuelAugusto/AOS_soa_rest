package com.project.professor.allocation.emanuelaugusto.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "departmentId", nullable = false)
	private Long departmentId;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonIgnoreProperties({ "teachers" })
	@ManyToOne(optional = false)
	@JoinColumn(name = "departmentId", nullable = false, insertable = false, updatable = false)
	private Department department;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "teacher")
	private List<Allocation> allocations;

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

	public Long getdepartmentId() {
		return departmentId;
	}

	public void setdepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Department getdepartment() {
		return department;
	}

	public void setdepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Professor{" +
				"id=" + id +
				", name='" + name + '\'' +
				", cpf='" + cpf + '\'' +
				", departmentId=" + departmentId +
				", department=" + department +
				'}';
	}
}
