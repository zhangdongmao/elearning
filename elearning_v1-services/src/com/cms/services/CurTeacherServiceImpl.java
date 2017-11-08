package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.CurCourse;
import com.cms.beans.CurTeacher;
import com.cms.dao.ICurTeacherDao;
import com.cms.dto.CurCourseDto;
import com.cms.dto.CurTeacherDto;

@Service
public class CurTeacherServiceImpl extends BaseServiceImpl<CurTeacher> implements ICurTeacherService {
	
	private ICurTeacherDao CurTeacher;
	
	
	@Autowired
	public void setCourseDao(ICurTeacherDao TeacherDao) {
		this.CurTeacher = TeacherDao;
		this.setBaseDao(TeacherDao);
	}


	@Override
	public List<CurTeacherDto> list() {
		String hsql = "from CurTeacher";
		
		//获取数据
		List<CurTeacher> teacher = this.list(hsql);
		
		if(teacher==null){
			System.out.println("-------------null------------------");
		}
		//将pojo的数据转换成dto，使用BeanUtils.copyProperties 可以简化
		List<CurTeacherDto> teacherDtos = new ArrayList();
		for (int i = 0; i < teacher.size(); i++) {
			CurTeacherDto curTeacherDto = new CurTeacherDto();
			//courseDto.setCode(courses.get(i).getCode());不用这么麻烦
			BeanUtils.copyProperties(teacher.get(i), curTeacherDto);
			teacherDtos.add(curTeacherDto);
		}
		
		return teacherDtos;
	}
	
	
}
