package com.cms.services;

import java.util.List;

import com.cms.beans.CurCourse;
import com.cms.beans.CurTeacher;
import com.cms.dto.CurCourseDto;
import com.cms.dto.CurTeacherDto;

public interface ICurTeacherService extends IBaseService<CurTeacher> {
	List<CurTeacherDto> list();
}
