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
 * UacRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uac_role", catalog = "elearning")

public class UacRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private Set<CurTeacher> curTeachers = new HashSet<CurTeacher>(0);
	private Set<UacRoleRight> uacRoleRights = new HashSet<UacRoleRight>(0);
	private Set<Register> registers = new HashSet<Register>(0);
	private Set<Admin> admins = new HashSet<Admin>(0);

	// Constructors

	/** default constructor */
	public UacRole() {
	}

	/** minimal constructor */
	public UacRole(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/** full constructor */
	public UacRole(String code, String name, Set<CurTeacher> curTeachers, Set<UacRoleRight> uacRoleRights,
			Set<Register> registers, Set<Admin> admins) {
		this.code = code;
		this.name = name;
		this.curTeachers = curTeachers;
		this.uacRoleRights = uacRoleRights;
		this.registers = registers;
		this.admins = admins;
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

	@Column(name = "code", nullable = false, length = 50)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 50)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacRole")

	public Set<CurTeacher> getCurTeachers() {
		return this.curTeachers;
	}

	public void setCurTeachers(Set<CurTeacher> curTeachers) {
		this.curTeachers = curTeachers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacRole")

	public Set<UacRoleRight> getUacRoleRights() {
		return this.uacRoleRights;
	}

	public void setUacRoleRights(Set<UacRoleRight> uacRoleRights) {
		this.uacRoleRights = uacRoleRights;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacRole")

	public Set<Register> getRegisters() {
		return this.registers;
	}

	public void setRegisters(Set<Register> registers) {
		this.registers = registers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacRole")

	public Set<Admin> getAdmins() {
		return this.admins;
	}

	public void setAdmins(Set<Admin> admins) {
		this.admins = admins;
	}

}