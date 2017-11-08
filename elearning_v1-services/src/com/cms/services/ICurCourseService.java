package com.cms.services;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import com.cms.beans.CurCourse;
import com.cms.dto.CurCourseDto;

public interface ICurCourseService extends IBaseService<CurCourse> {
	List<CurCourseDto> list();
	
	void update(CurCourseDto curCourseDto);
	
	void save(CurCourseDto curCourseDto);
}
