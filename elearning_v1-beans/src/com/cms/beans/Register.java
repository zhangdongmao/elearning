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
 * Register entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "register", catalog = "elearning")

public class Register implements java.io.Serializable {

	// Fields

	private Integer id;
	private UacRole uacRole;
	private String username;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String gender;
	private Set<UacUserinfor> uacUserinfors = new HashSet<UacUserinfor>(0);

	// Constructors

	/** default constructor */
	public Register() {
	}

	/** minimal constructor */
	public Register(UacRole uacRole, String username, String email, String password, String name, String phone,
			String gender) {
		this.uacRole = uacRole;
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
	}

	/** full constructor */
	public Register(UacRole uacRole, String username, String email, String password, String name, String phone,
			String gender, Set<UacUserinfor> uacUserinfors) {
		this.uacRole = uacRole;
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.uacUserinfors = uacUserinfors;
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
	@JoinColumn(name = "role_id", nullable = false)

	public UacRole getUacRole() {
		return this.uacRole;
	}

	public void setUacRole(UacRole uacRole) {
		this.uacRole = uacRole;
	}

	@Column(name = "username", nullable = false, length = 50)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email", nullable = false, length = 50)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 50)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", nullable = false, length = 50)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", nullable = false, length = 50)

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "gender", nullable = false, length = 50)

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "register")

	public Set<UacUserinfor> getUacUserinfors() {
		return this.uacUserinfors;
	}

	public void setUacUserinfors(Set<UacUserinfor> uacUserinfors) {
		this.uacUserinfors = uacUserinfors;
	}

}