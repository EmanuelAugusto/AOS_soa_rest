package com.project.professor.allocation.emanuelaugusto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "course")
public class Course {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(mappedBy = "course")
	@OnDelete(action = OnDeleteAction.CASCADE)
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

	public List<Allocation> getAllocations() {
		return allocations;
	}

	public void setAllocations(List<Allocation> allocations) {
		this.allocations = allocations;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

}
