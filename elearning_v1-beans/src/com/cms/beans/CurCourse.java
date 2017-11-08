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
 * CurCourse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_course", catalog = "elearning")

public class CurCourse implements java.io.Serializable {

	// Fields

	private Integer id;
	private CurType curType;
	private CurTeacher curTeacher;
	private String code;
	private String curName;
	private String curIntroduce;
	private String curGoal;
	private String curTargetUser;
	private String curStartTime;
	private String curApplicantsTime;
	private String recommend;
	private String curNumberApplicants;
	private String curPhoto;
	private String curHour;
	private Set<CurData> curDatas = new HashSet<CurData>(0);
	private Set<CurTraining> curTrainings = new HashSet<CurTraining>(0);
	private Set<CurEvaluate> curEvaluates = new HashSet<CurEvaluate>(0);

	// Constructors

	/** default constructor */
	public CurCourse() {
	}

	/** minimal constructor */
	public CurCourse(CurType curType, CurTeacher curTeacher) {
		this.curType = curType;
		this.curTeacher = curTeacher;
	}

	/** full constructor */
	public CurCourse(CurType curType, CurTeacher curTeacher, String code, String curName, String curIntroduce,
			String curGoal, String curTargetUser, String curStartTime, String curApplicantsTime, String recommend,
			String curNumberApplicants, String curPhoto, String curHour, Set<CurData> curDatas,
			Set<CurTraining> curTrainings, Set<CurChapter> curChapters, Set<CurEvaluate> curEvaluates) {
		this.curType = curType;
		this.curTeacher = curTeacher;
		this.code = code;
		this.curName = curName;
		this.curIntroduce = curIntroduce;
		this.curGoal = curGoal;
		this.curTargetUser = curTargetUser;
		this.curStartTime = curStartTime;
		this.curApplicantsTime = curApplicantsTime;
		this.recommend = recommend;
		this.curNumberApplicants = curNumberApplicants;
		this.curPhoto = curPhoto;
		this.curHour = curHour;
		this.curDatas = curDatas;
		this.curTrainings = curTrainings;
		this.curEvaluates = curEvaluates;
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

	public CurType getCurType() {
		return this.curType;
	}

	public void setCurType(CurType curType) {
		this.curType = curType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cur_teacher_id", nullable = false)

	public CurTeacher getCurTeacher() {
		return this.curTeacher;
	}

	public void setCurTeacher(CurTeacher curTeacher) {
		this.curTeacher = curTeacher;
	}

	@Column(name = "code", length = 50)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "cur_name", length = 50)

	public String getCurName() {
		return this.curName;
	}

	public void setCurName(String curName) {
		this.curName = curName;
	}

	@Column(name = "cur_introduce", length = 65535)

	public String getCurIntroduce() {
		return this.curIntroduce;
	}

	public void setCurIntroduce(String curIntroduce) {
		this.curIntroduce = curIntroduce;
	}

	@Column(name = "cur_goal", length = 150)

	public String getCurGoal() {
		return this.curGoal;
	}

	public void setCurGoal(String curGoal) {
		this.curGoal = curGoal;
	}

	@Column(name = "cur_target_user", length = 150)

	public String getCurTargetUser() {
		return this.curTargetUser;
	}

	public void setCurTargetUser(String curTargetUser) {
		this.curTargetUser = curTargetUser;
	}

	@Column(name = "cur_start_time", length = 50)

	public String getCurStartTime() {
		return this.curStartTime;
	}

	public void setCurStartTime(String curStartTime) {
		this.curStartTime = curStartTime;
	}

	@Column(name = "cur_applicants_time", length = 50)

	public String getCurApplicantsTime() {
		return this.curApplicantsTime;
	}

	public void setCurApplicantsTime(String curApplicantsTime) {
		this.curApplicantsTime = curApplicantsTime;
	}

	@Column(name = "recommend", length = 50)

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	@Column(name = "cur_number_applicants", length = 50)

	public String getCurNumberApplicants() {
		return this.curNumberApplicants;
	}

	public void setCurNumberApplicants(String curNumberApplicants) {
		this.curNumberApplicants = curNumberApplicants;
	}

	@Column(name = "cur_photo", length = 50)

	public String getCurPhoto() {
		return this.curPhoto;
	}

	public void setCurPhoto(String curPhoto) {
		this.curPhoto = curPhoto;
	}

	@Column(name = "cur_hour", length = 50)

	public String getCurHour() {
		return this.curHour;
	}

	public void setCurHour(String curHour) {
		this.curHour = curHour;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curCourse")

	public Set<CurData> getCurDatas() {
		return this.curDatas;
	}

	public void setCurDatas(Set<CurData> curDatas) {
		this.curDatas = curDatas;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curCourse")

	public Set<CurTraining> getCurTrainings() {
		return this.curTrainings;
	}

	public void setCurTrainings(Set<CurTraining> curTrainings) {
		this.curTrainings = curTrainings;
	}



	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curCourse")

	public Set<CurEvaluate> getCurEvaluates() {
		return this.curEvaluates;
	}

	public void setCurEvaluates(Set<CurEvaluate> curEvaluates) {
		this.curEvaluates = curEvaluates;
	}

}