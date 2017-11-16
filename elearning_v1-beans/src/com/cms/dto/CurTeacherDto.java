package com.cms.dto;


public class CurTeacherDto {
	
	private Integer id;
	private String name;
	private String teacherIntroduce;
	private String position;
	private String level;
	private String username;
	private String password;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacherIntroduce() {
		return teacherIntroduce;
	}
	public void setTeacherIntroduce(String teacherIntroduce) {
		this.teacherIntroduce = teacherIntroduce;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CurTeacherDto [id=" + id + ", name=" + name + ", teacherIntroduce=" + teacherIntroduce
				+ ", position=" + position + ", level=" + level + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
}
