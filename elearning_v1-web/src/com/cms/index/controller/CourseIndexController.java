package com.cms.index.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.beans.CurCourse;
import com.cms.services.ICurCourseService;
import com.cms.services.ICurTeacherService;
import com.cms.services.ICurTypeService;

@Controller
@RequestMapping("course/index")
public class CourseIndexController {
	
	@Autowired
	private ICurCourseService courseService;
	@Autowired
	private ICurTypeService courseTypeService;
	@Autowired
	private ICurTeacherService courseTeacherService;
	
	@RequestMapping("/list")
	public String courseIndexList(Model model){
		String courseHsql="from CurCourse co left join fetch co.curType ty"
				+" left join fetch co.curTeacher te";
		List<CurCourse> courses=courseService.queryPage(courseHsql, 0, 15);
		int i=0;
		for (CurCourse curCourse : courses) {
			i++;
			System.out.println(curCourse.getCurType().getName()+":"+curCourse.getCurTeacher().getName()+":"+i);
		}
		
		model.addAttribute("courses",courses);
		return "/wkCourse/course";
	}
}
