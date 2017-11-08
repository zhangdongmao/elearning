package com.cms.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CurTeacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_teacher", catalog = "elearning")

public class CurTeacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private UacUserinfor uacUserinfor;
	private UacRole uacRole;
	private String name;
	private String teacherIntroduce;
	private String position;
	private String level;
	private String teacherPhoto;
	private String username;
	private String password;
	private Set<CurTraining> curTrainings = new HashSet<CurTraining>(0);
	private Set<CurCourse> curCourses = new HashSet<CurCourse>(0);

	// Constructors

	/** default constructor */
	public CurTeacher() {
	}

	/** minimal constructor */
	public CurTeacher(UacRole uacRole, String name, String username, String password) {
		this.uacRole = uacRole;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public CurTeacher(UacUserinfor uacUserinfor, UacRole uacRole, String name, String teacherIntroduce, String position,
			String level, String teacherPhoto, String username, String password, Set<CurTraining> curTrainings,
			Set<CurCourse> curCourses) {
		this.uacUserinfor = uacUserinfor;
		this.uacRole = uacRole;
		this.name = name;
		this.teacherIntroduce = teacherIntroduce;
		this.position = position;
		this.level = level;
		this.teacherPhoto = teacherPhoto;
		this.username = username;
		this.password = password;
		this.curTrainings = curTrainings;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")

	public UacUserinfor getUacUserinfor() {
		return this.uacUserinfor;
	}

	public void setUacUserinfor(UacUserinfor uacUserinfor) {
		this.uacUserinfor = uacUserinfor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)

	public UacRole getUacRole() {
		return this.uacRole;
	}

	public void setUacRole(UacRole uacRole) {
		this.uacRole = uacRole;
	}

	@Column(name = "name", nullable = false, length = 50)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "teacher_introduce", length = 65535)

	public String getTeacherIntroduce() {
		return this.teacherIntroduce;
	}

	public void setTeacherIntroduce(String teacherIntroduce) {
		this.teacherIntroduce = teacherIntroduce;
	}

	@Column(name = "position", length = 50)

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "level", length = 50)

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name = "teacher_photo", length = 50)

	public String getTeacherPhoto() {
		return this.teacherPhoto;
	}

	public void setTeacherPhoto(String teacherPhoto) {
		this.teacherPhoto = teacherPhoto;
	}

	@Column(name = "username", nullable = false, length = 50)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curTeacher")

	public Set<CurTraining> getCurTrainings() {
		return this.curTrainings;
	}

	public void setCurTrainings(Set<CurTraining> curTrainings) {
		this.curTrainings = curTrainings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curTeacher")

	public Set<CurCourse> getCurCourses() {
		return this.curCourses;
	}

	public void setCurCourses(Set<CurCourse> curCourses) {
		this.curCourses = curCourses;
	}

}