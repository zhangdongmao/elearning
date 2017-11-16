package com.cms.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Login entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "login", catalog = "elearning")

public class Login implements java.io.Serializable {

	// Fields

	private Integer id;
	private UacRole uacRole;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public Login() {
	}

	/** full constructor */
	public Login(UacRole uacRole, String username, String password) {
		this.uacRole = uacRole;
		this.username = username;
		this.password = password;
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

	@Column(name = "password", nullable = false, length = 50)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}