package com.cms.dto;

import java.util.HashSet;
import java.util.Set;

import com.cms.beans.CurCourse;
import com.cms.beans.CurSection;

public class CurChapterDto {
	private Integer id;
	private CurCourse curCourse;
	private String chapterName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	
	public CurCourse getCurCourse() {
		return curCourse;
	}
	public void setCurCourse(CurCourse curCourse) {
		this.curCourse = curCourse;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
