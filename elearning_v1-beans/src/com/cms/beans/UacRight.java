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
 * UacRight entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uac_right", catalog = "elearning")

public class UacRight implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private Set<UacRoleRight> uacRoleRights = new HashSet<UacRoleRight>(0);

	// Constructors

	/** default constructor */
	public UacRight() {
	}

	/** minimal constructor */
	public UacRight(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/** full constructor */
	public UacRight(String code, String name, Set<UacRoleRight> uacRoleRights) {
		this.code = code;
		this.name = name;
		this.uacRoleRights = uacRoleRights;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacRight")

	public Set<UacRoleRight> getUacRoleRights() {
		return this.uacRoleRights;
	}

	public void setUacRoleRights(Set<UacRoleRight> uacRoleRights) {
		this.uacRoleRights = uacRoleRights;
	}

}