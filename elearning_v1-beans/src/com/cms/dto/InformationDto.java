package com.cms.dto;

import com.cms.beans.InformationType;

public class InformationDto {
	private Integer id;
	private String informationTitle;
	private String informationReleaseTime;
	private String informationPhoto;
	private String informationInfo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInformationTitle() {
		return informationTitle;
	}
	public void setInformationTitle(String informationTitle) {
		this.informationTitle = informationTitle;
	}
	public String getInformationReleaseTime() {
		return informationReleaseTime;
	}
	public void setInformationReleaseTime(String informationReleaseTime) {
		this.informationReleaseTime = informationReleaseTime;
	}
	public String getInformationPhoto() {
		return informationPhoto;
	}
	public void setInformationPhoto(String informationPhoto) {
		this.informationPhoto = informationPhoto;
	}
	public String getInformationInfo() {
		return informationInfo;
	}
	public void setInformationInfo(String informationInfo) {
		this.informationInfo = informationInfo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
