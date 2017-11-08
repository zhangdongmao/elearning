package com.cms.dto;

import com.cms.beans.CurCourse;
import com.cms.beans.CurTeacher;
import com.cms.beans.TrainingName;

public class CurTrainingDto {
	
	private Integer id;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrainingTime() {
		return trainingTime;
	}
	public void setTrainingTime(String trainingTime) {
		this.trainingTime = trainingTime;
	}
	public String getSponsorDepartment() {
		return sponsorDepartment;
	}
	public void setSponsorDepartment(String sponsorDepartment) {
		this.sponsorDepartment = sponsorDepartment;
	}
	public String getMaximumQuota() {
		return maximumQuota;
	}
	public void setMaximumQuota(String maximumQuota) {
		this.maximumQuota = maximumQuota;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getApplicantsTime() {
		return applicantsTime;
	}
	public void setApplicantsTime(String applicantsTime) {
		this.applicantsTime = applicantsTime;
	}
	public String getTrainingLocation() {
		return trainingLocation;
	}
	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getNumberApplicants() {
		return numberApplicants;
	}
	public void setNumberApplicants(String numberApplicants) {
		this.numberApplicants = numberApplicants;
	}
	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}
	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}
	public String getTrainingSynopsis() {
		return trainingSynopsis;
	}
	public void setTrainingSynopsis(String trainingSynopsis) {
		this.trainingSynopsis = trainingSynopsis;
	}
	public String getTrainingInfor() {
		return trainingInfor;
	}
	public void setTrainingInfor(String trainingInfor) {
		this.trainingInfor = trainingInfor;
	}
	public String getTrainingUser() {
		return trainingUser;
	}
	public void setTrainingUser(String trainingUser) {
		this.trainingUser = trainingUser;
	}
	public String getTrainingNotice() {
		return trainingNotice;
	}
	public void setTrainingNotice(String trainingNotice) {
		this.trainingNotice = trainingNotice;
	}
	public String getTrainingPhoto() {
		return trainingPhoto;
	}
	public void setTrainingPhoto(String trainingPhoto) {
		this.trainingPhoto = trainingPhoto;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
