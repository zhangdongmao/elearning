package com.cms.dto;

import com.cms.beans.KnowledgeType;
import com.cms.beans.UacUserinfor;

public class KnowledgeDto {
	private Integer id;
	private String name;
	private String updateTime;
	private String browserCount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getBrowserCount() {
		return browserCount;
	}
	public void setBrowserCount(String browserCount) {
		this.browserCount = browserCount;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
