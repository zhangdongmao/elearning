package com.cms.dto;

public class KnowledgeDto {
	private Integer id;
	private String name;
	private String updateTime;
	private String browserCount;
	private String ktname;
	private String nickname;
	
	@Override
	public String toString() {
		return "KnowledgeDto [id=" + id + ", name=" + name + ", updateTime=" + updateTime + ", browserCount="
				+ browserCount + ", ktname=" + ktname + ", nickname=" + nickname + "]";
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getKtname() {
		return ktname;
	}
	public void setKtname(String ktname) {
		this.ktname = ktname;
	}
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
	
	
	
	
}
