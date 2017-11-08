package com.cms.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CurType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_type", catalog = "elearning")

public class CurType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String code;
	private Set<CurCourse> curCourses = new HashSet<CurCourse>(0);

	// Constructors

	/** default constructor */
	public CurType() {
	}

	/** minimal constructor */
	public CurType(String name) {
		this.name = name;
	}

	/** full constructor */
	public CurType(String name, String code, Set<CurCourse> curCourses) {
		this.name = name;
		this.code = code;
		this.curCourses = curCourses;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", length = 50)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curType")

	public Set<CurCourse> getCurCourses() {
		return this.curCourses;
	}

	public void setCurCourses(Set<CurCourse> curCourses) {
		this.curCourses = curCourses;
	}

}