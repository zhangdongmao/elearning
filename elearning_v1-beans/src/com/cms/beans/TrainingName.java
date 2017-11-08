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
 * TrainingName entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "training_name", catalog = "elearning")

public class TrainingName implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<CurTraining> curTrainings = new HashSet<CurTraining>(0);

	// Constructors

	/** default constructor */
	public TrainingName() {
	}

	/** full constructor */
	public TrainingName(String name, Set<CurTraining> curTrainings) {
		this.name = name;
		this.curTrainings = curTrainings;
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

	@Column(name = "name", length = 50)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "trainingName")

	public Set<CurTraining> getCurTrainings() {
		return this.curTrainings;
	}

	public void setCurTrainings(Set<CurTraining> curTrainings) {
		this.curTrainings = curTrainings;
	}

}