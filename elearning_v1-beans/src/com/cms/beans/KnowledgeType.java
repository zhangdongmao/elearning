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
 * KnowledgeType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knowledge_type", catalog = "elearning")

public class KnowledgeType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String code;
	private Set<Knowledge> knowledges = new HashSet<Knowledge>(0);

	// Constructors

	/** default constructor */
	public KnowledgeType() {
	}

	/** minimal constructor */
	public KnowledgeType(String name, String code) {
		this.name = name;
		this.code = code;
	}

	/** full constructor */
	public KnowledgeType(String name, String code, Set<Knowledge> knowledges) {
		this.name = name;
		this.code = code;
		this.knowledges = knowledges;
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

	@Column(name = "code", nullable = false, length = 50)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "knowledgeType")

	public Set<Knowledge> getKnowledges() {
		return this.knowledges;
	}

	public void setKnowledges(Set<Knowledge> knowledges) {
		this.knowledges = knowledges;
	}

}