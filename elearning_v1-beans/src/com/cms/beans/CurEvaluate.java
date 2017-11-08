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
 * CurEvaluate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_evaluate", catalog = "elearning")

public class CurEvaluate implements java.io.Serializable {

	// Fields

	private Integer id;
	private UacUserinfor uacUserinfor;
	private CurCourse curCourse;
	private String curEvaluate;
	private String evaluateTime;

	// Constructors

	/** default constructor */
	public CurEvaluate() {
	}

	/** minimal constructor */
	public CurEvaluate(UacUserinfor uacUserinfor, CurCourse curCourse) {
		this.uacUserinfor = uacUserinfor;
		this.curCourse = curCourse;
	}

	/** full constructor */
	public CurEvaluate(UacUserinfor uacUserinfor, CurCourse curCourse, String curEvaluate, String evaluateTime) {
		this.uacUserinfor = uacUserinfor;
		this.curCourse = curCourse;
		this.curEvaluate = curEvaluate;
		this.evaluateTime = evaluateTime;
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
	@JoinColumn(name = "cur_type_id", nullable = false)

	public CurCourse getCurCourse() {
		return this.curCourse;
	}

	public void setCurCourse(CurCourse curCourse) {
		this.curCourse = curCourse;
	}

	@Column(name = "cur_evaluate", length = 65535)

	public String getCurEvaluate() {
		return this.curEvaluate;
	}

	public void setCurEvaluate(String curEvaluate) {
		this.curEvaluate = curEvaluate;
	}

	@Column(name = "evaluate_time", length = 50)

	public String getEvaluateTime() {
		return this.evaluateTime;
	}

	public void setEvaluateTime(String evaluateTime) {
		this.evaluateTime = evaluateTime;
	}

}