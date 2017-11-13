package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cms.beans.CurCourse;
import com.cms.dao.ICurCourseDao;
import com.cms.dto.CurCourseDto;

@Service
public class CurCourseServiceImpl extends BaseServiceImpl<CurCourse> implements ICurCourseService {
	
	private ICurCourseDao courseDao;
	
	
	@Autowired
	public void setCourseDao(ICurCourseDao courseDao) {
		this.courseDao = courseDao;
		this.setBaseDao(courseDao);
	}


	@Override
	public List<CurCourseDto> list() {
		String hsql = "from CurCourse";
		
		//获取数据
		List<CurCourse> courses = this.list(hsql);
		
		if(courses==null){
			System.out.println("-------------null------------------");
		}
		//将pojo的数据转换成dto，使用BeanUtils.copyProperties 可以简化
		List<CurCourseDto> courseDtos = new ArrayList();
		for (int i = 0; i < courses.size(); i++) {
			CurCourseDto courseDto = new CurCourseDto();
			//courseDto.setCode(courses.get(i).getCode());不用这么麻烦
			BeanUtils.copyProperties(courses.get(i), courseDto);
			courseDtos.add(courseDto);
		}
		
		return courseDtos;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(CurCourseDto curCourseDto) {
		CurCourse curCourse = new CurCourse();
		BeanUtils.copyProperties(curCourseDto, curCourse);
		this.update(curCourse);
	}


	@Override
	public void save(CurCourseDto curCourseDto) {
		CurCourse curCourse = new CurCourse();
		BeanUtils.copyProperties(curCourseDto, curCourse);
		this.save(curCourse);
		
	}




	
	
}
