package com.project.professor.allocation.emanuelaugusto.entity;

import java.time.DayOfWeek;
import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "allocation")
public class Allocation {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "day", nullable = false)
	private DayOfWeek day;

	@ApiModelProperty(example = "19:00-0300")
	@JsonFormat(pattern = "HH:mmZ")
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Column(name = "startHour", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date start;

	@ApiModelProperty(example = "19:00-0300")
	@JsonFormat(pattern = "HH:mmZ")
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Column(name = "endHour", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date end;

	@Column(name = "teacherId", nullable = false)
	private Long teacherId;

	@Column(name = "courseId", nullable = false)
	private Long courseId;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonIgnoreProperties({ "allocations" })
	@ManyToOne(optional = false)
	@JoinColumn(name = "courseId", nullable = false, insertable = false, updatable = false)
	private Course course;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonIgnoreProperties({ "allocations" })
	@ManyToOne(optional = false)
	@JoinColumn(name = "teacherId", nullable = false, insertable = false, updatable = false)
	private Teacher teacher;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Allocation{" +
				"id=" + id +
				", day=" + day +
				", start=" + start +
				", end=" + end +
				", teacherId=" + teacherId +
				", courseId=" + courseId +
				", teacher=" + teacher +
				", course=" + course +
				'}';
	}
}
