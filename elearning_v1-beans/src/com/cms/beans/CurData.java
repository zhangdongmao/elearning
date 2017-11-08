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
 * CurData entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_data", catalog = "elearning")

public class CurData implements java.io.Serializable {

	// Fields

	private Integer id;
	private CurCourse curCourse;
	private String documentName;
	private String documentType;
	private String documentSize;
	private String operation;
	private Set<CurUser> curUsers = new HashSet<CurUser>(0);

	// Constructors

	/** default constructor */
	public CurData() {
	}

	/** minimal constructor */
	public CurData(CurCourse curCourse) {
		this.curCourse = curCourse;
	}

	/** full constructor */
	public CurData(CurCourse curCourse, String documentName, String documentType, String documentSize, String operation,
			Set<CurUser> curUsers) {
		this.curCourse = curCourse;
		this.documentName = documentName;
		this.documentType = documentType;
		this.documentSize = documentSize;
		this.operation = operation;
		this.curUsers = curUsers;
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
	@JoinColumn(name = "cur_type_id", nullable = false)

	public CurCourse getCurCourse() {
		return this.curCourse;
	}

	public void setCurCourse(CurCourse curCourse) {
		this.curCourse = curCourse;
	}

	@Column(name = "document_name", length = 50)

	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@Column(name = "document_type", length = 50)

	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	@Column(name = "document_size", length = 50)

	public String getDocumentSize() {
		return this.documentSize;
	}

	public void setDocumentSize(String documentSize) {
		this.documentSize = documentSize;
	}

	@Column(name = "operation", length = 50)

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curData")

	public Set<CurUser> getCurUsers() {
		return this.curUsers;
	}

	public void setCurUsers(Set<CurUser> curUsers) {
		this.curUsers = curUsers;
	}

}