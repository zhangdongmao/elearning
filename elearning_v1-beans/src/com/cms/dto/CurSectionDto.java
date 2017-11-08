package com.cms.dto;

import com.cms.beans.CurChapter;

public class CurSectionDto {
	private Integer id;
	private String sectionName;
	private String curMovieFile;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getCurMovieFile() {
		return curMovieFile;
	}
	public void setCurMovieFile(String curMovieFile) {
		this.curMovieFile = curMovieFile;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
