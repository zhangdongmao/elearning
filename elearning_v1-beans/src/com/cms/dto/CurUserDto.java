package com.cms.dto;

import com.cms.beans.CurData;
import com.cms.beans.UacUserinfor;

public class CurUserDto {
	private Integer id;
	private String learnedHours;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLearnedHours() {
		return learnedHours;
	}
	public void setLearnedHours(String learnedHours) {
		this.learnedHours = learnedHours;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
