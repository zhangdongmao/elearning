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
 * CurUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_user", catalog = "elearning")

public class CurUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private UacUserinfor uacUserinfor;
	private CurData curData;
	private String learnedHours;

	// Constructors

	/** default constructor */
	public CurUser() {
	}

	/** minimal constructor */
	public CurUser(UacUserinfor uacUserinfor, CurData curData) {
		this.uacUserinfor = uacUserinfor;
		this.curData = curData;
	}

	/** full constructor */
	public CurUser(UacUserinfor uacUserinfor, CurData curData, String learnedHours) {
		this.uacUserinfor = uacUserinfor;
		this.curData = curData;
		this.learnedHours = learnedHours;
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
	@JoinColumn(name = "cur_id", nullable = false)

	public CurData getCurData() {
		return this.curData;
	}

	public void setCurData(CurData curData) {
		this.curData = curData;
	}

	@Column(name = "learned_hours", length = 50)

	public String getLearnedHours() {
		return this.learnedHours;
	}

	public void setLearnedHours(String learnedHours) {
		this.learnedHours = learnedHours;
	}

}