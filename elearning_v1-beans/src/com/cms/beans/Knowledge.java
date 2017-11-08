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
 * Knowledge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knowledge", catalog = "elearning")

public class Knowledge implements java.io.Serializable {

	// Fields

	private Integer id;
	private UacUserinfor uacUserinfor;
	private KnowledgeType knowledgeType;
	private String name;
	private String updateTime;
	private String browserCount;

	// Constructors

	/** default constructor */
	public Knowledge() {
	}

	/** minimal constructor */
	public Knowledge(UacUserinfor uacUserinfor, KnowledgeType knowledgeType, String name) {
		this.uacUserinfor = uacUserinfor;
		this.knowledgeType = knowledgeType;
		this.name = name;
	}

	/** full constructor */
	public Knowledge(UacUserinfor uacUserinfor, KnowledgeType knowledgeType, String name, String updateTime,
			String browserCount) {
		this.uacUserinfor = uacUserinfor;
		this.knowledgeType = knowledgeType;
		this.name = name;
		this.updateTime = updateTime;
		this.browserCount = browserCount;
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
	@JoinColumn(name = "user_id", nullable = false)

	public UacUserinfor getUacUserinfor() {
		return this.uacUserinfor;
	}

	public void setUacUserinfor(UacUserinfor uacUserinfor) {
		this.uacUserinfor = uacUserinfor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "knowledge_type_id", nullable = false)

	public KnowledgeType getKnowledgeType() {
		return this.knowledgeType;
	}

	public void setKnowledgeType(KnowledgeType knowledgeType) {
		this.knowledgeType = knowledgeType;
	}

	@Column(name = "name", nullable = false, length = 50)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "update_time", length = 50)

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "browser_count", length = 50)

	public String getBrowserCount() {
		return this.browserCount;
	}

	public void setBrowserCount(String browserCount) {
		this.browserCount = browserCount;
	}

}