package com.cms.dto;

import com.cms.beans.CurChapter;
import com.cms.beans.CurTeacher;
import com.cms.beans.CurType;

public class CurCourseDto {
	private Integer id;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCurName() {
		return curName;
	}
	public void setCurName(String curName) {
		this.curName = curName;
	}
	
	public String getCurIntroduce() {
		return curIntroduce;
	}
	public void setCurIntroduce(String curIntroduce) {
		this.curIntroduce = curIntroduce;
	}
	public String getCurGoal() {
		return curGoal;
	}
	public void setCurGoal(String curGoal) {
		this.curGoal = curGoal;
	}
	public String getCurTargetUser() {
		return curTargetUser;
	}
	public void setCurTargetUser(String curTargetUser) {
		this.curTargetUser = curTargetUser;
	}
	public String getCurStartTime() {
		return curStartTime;
	}
	public void setCurStartTime(String curStartTime) {
		this.curStartTime = curStartTime;
	}
	public String getCurApplicantsTime() {
		return curApplicantsTime;
	}
	public void setCurApplicantsTime(String curApplicantsTime) {
		this.curApplicantsTime = curApplicantsTime;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getCurNumberApplicants() {
		return curNumberApplicants;
	}
	public void setCurNumberApplicants(String curNumberApplicants) {
		this.curNumberApplicants = curNumberApplicants;
	}
	public String getCurPhoto() {
		return curPhoto;
	}
	public void setCurPhoto(String curPhoto) {
		this.curPhoto = curPhoto;
	}
	public String getCurHour() {
		return curHour;
	}
	public void setCurHour(String curHour) {
		this.curHour = curHour;
	}
	@Override
	public String toString() {
		
		return super.toString();
	}
	
	
}
