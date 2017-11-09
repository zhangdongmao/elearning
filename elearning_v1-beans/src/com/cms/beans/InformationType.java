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
 * InformationType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "information_type", catalog = "elearning")

public class InformationType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Information> informations = new HashSet<Information>(0);

	// Constructors

	/** default constructor */
	public InformationType() {
	}

	/** minimal constructor */
	public InformationType(String name) {
		this.name = name;
	}

	/** full constructor */
	public InformationType(String name, Set<Information> informations) {
		this.name = name;
		this.informations = informations;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "informationType")

	public Set<Information> getInformations() {
		return this.informations;
	}

	public void setInformations(Set<Information> informations) {
		this.informations = informations;
	}

}