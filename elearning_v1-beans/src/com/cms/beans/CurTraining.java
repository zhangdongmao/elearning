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
 * CurTraining entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_training", catalog = "elearning")

public class CurTraining implements java.io.Serializable {

	// Fields

	private Integer id;
	private CurTeacher curTeacher;
	private CurCourse curCourse;
	private TrainingName trainingName;
	private String trainingTime;
	private String sponsorDepartment;
	private String maximumQuota;
	private String contacts;
	private String applicantsTime;
	private String trainingLocation;
	private String manager;
	private String numberApplicants;
	private String enrollmentStatus;
	private String trainingSynopsis;
	private String trainingInfor;
	private String trainingUser;
	private String trainingNotice;
	private String trainingPhoto;

	// Constructors

	/** default constructor */
	public CurTraining() {
	}

	/** minimal constructor */
	public CurTraining(CurTeacher curTeacher, CurCourse curCourse, TrainingName trainingName) {
		this.curTeacher = curTeacher;
		this.curCourse = curCourse;
		this.trainingName = trainingName;
	}

	/** full constructor */
	public CurTraining(CurTeacher curTeacher, CurCourse curCourse, TrainingName trainingName, String trainingTime,
			String sponsorDepartment, String maximumQuota, String contacts, String applicantsTime,
			String trainingLocation, String manager, String numberApplicants, String enrollmentStatus,
			String trainingSynopsis, String trainingInfor, String trainingUser, String trainingNotice,
			String trainingPhoto) {
		this.curTeacher = curTeacher;
		this.curCourse = curCourse;
		this.trainingName = trainingName;
		this.trainingTime = trainingTime;
		this.sponsorDepartment = sponsorDepartment;
		this.maximumQuota = maximumQuota;
		this.contacts = contacts;
		this.applicantsTime = applicantsTime;
		this.trainingLocation = trainingLocation;
		this.manager = manager;
		this.numberApplicants = numberApplicants;
		this.enrollmentStatus = enrollmentStatus;
		this.trainingSynopsis = trainingSynopsis;
		this.trainingInfor = trainingInfor;
		this.trainingUser = trainingUser;
		this.trainingNotice = trainingNotice;
		this.trainingPhoto = trainingPhoto;
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
	@JoinColumn(name = "ter_id", nullable = false)

	public CurTeacher getCurTeacher() {
		return this.curTeacher;
	}

	public void setCurTeacher(CurTeacher curTeacher) {
		this.curTeacher = curTeacher;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cur_id", nullable = false)

	public CurCourse getCurCourse() {
		return this.curCourse;
	}

	public void setCurCourse(CurCourse curCourse) {
		this.curCourse = curCourse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tra_id", nullable = false)

	public TrainingName getTrainingName() {
		return this.trainingName;
	}

	public void setTrainingName(TrainingName trainingName) {
		this.trainingName = trainingName;
	}

	@Column(name = "training_time", length = 50)

	public String getTrainingTime() {
		return this.trainingTime;
	}

	public void setTrainingTime(String trainingTime) {
		this.trainingTime = trainingTime;
	}

	@Column(name = "sponsor_department", length = 50)

	public String getSponsorDepartment() {
		return this.sponsorDepartment;
	}

	public void setSponsorDepartment(String sponsorDepartment) {
		this.sponsorDepartment = sponsorDepartment;
	}

	@Column(name = "maximum_quota", length = 50)

	public String getMaximumQuota() {
		return this.maximumQuota;
	}

	public void setMaximumQuota(String maximumQuota) {
		this.maximumQuota = maximumQuota;
	}

	@Column(name = "contacts", length = 50)

	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	@Column(name = "applicants_time", length = 50)

	public String getApplicantsTime() {
		return this.applicantsTime;
	}

	public void setApplicantsTime(String applicantsTime) {
		this.applicantsTime = applicantsTime;
	}

	@Column(name = "training_location", length = 50)

	public String getTrainingLocation() {
		return this.trainingLocation;
	}

	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}

	@Column(name = "manager", length = 50)

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Column(name = "number_applicants", length = 50)

	public String getNumberApplicants() {
		return this.numberApplicants;
	}

	public void setNumberApplicants(String numberApplicants) {
		this.numberApplicants = numberApplicants;
	}

	@Column(name = "enrollment_status", length = 50)

	public String getEnrollmentStatus() {
		return this.enrollmentStatus;
	}

	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	@Column(name = "training_synopsis", length = 65535)

	public String getTrainingSynopsis() {
		return this.trainingSynopsis;
	}

	public void setTrainingSynopsis(String trainingSynopsis) {
		this.trainingSynopsis = trainingSynopsis;
	}

	@Column(name = "training_infor", length = 65535)

	public String getTrainingInfor() {
		return this.trainingInfor;
	}

	public void setTrainingInfor(String trainingInfor) {
		this.trainingInfor = trainingInfor;
	}

	@Column(name = "training_user", length = 65535)

	public String getTrainingUser() {
		return this.trainingUser;
	}

	public void setTrainingUser(String trainingUser) {
		this.trainingUser = trainingUser;
	}

	@Column(name = "training_notice", length = 65535)

	public String getTrainingNotice() {
		return this.trainingNotice;
	}

	public void setTrainingNotice(String trainingNotice) {
		this.trainingNotice = trainingNotice;
	}

	@Column(name = "training_photo", length = 200)

	public String getTrainingPhoto() {
		return this.trainingPhoto;
	}

	public void setTrainingPhoto(String trainingPhoto) {
		this.trainingPhoto = trainingPhoto;
	}

}