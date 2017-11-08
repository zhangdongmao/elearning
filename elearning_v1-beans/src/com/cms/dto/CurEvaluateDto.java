package com.cms.dto;

import com.cms.beans.CurCourse;
import com.cms.beans.UacUserinfor;

public class CurEvaluateDto {
	private Integer id;
	private String curEvaluate;
	private String evaluateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCurEvaluate() {
		return curEvaluate;
	}
	public void setCurEvaluate(String curEvaluate) {
		this.curEvaluate = curEvaluate;
	}
	public String getEvaluateTime() {
		return evaluateTime;
	}
	public void setEvaluateTime(String evaluateTime) {
		this.evaluateTime = evaluateTime;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
