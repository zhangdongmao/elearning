package com.cms.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.beans.CurCourse;
import com.cms.beans.CurTeacher;
import com.cms.beans.CurType;
import com.cms.dto.CurCourseDto;
import com.cms.dto.CurTeacherDto;
import com.cms.dto.CurTypeDto;
import com.cms.dto.ResponseDto;
import com.cms.services.ICurCourseService;
import com.cms.services.ICurTeacherService;
import com.cms.services.ICurTypeService;

@Controller
@RequestMapping(value="/course")
public class CourseController {

	//controller如果能够得到service实例，就表明spring的MVC和service已经集成成功.
	@Autowired
	private ICurCourseService courseService;
	@Autowired
	private ICurTeacherService courseTeacherService;
	@Autowired
	private ICurTypeService courseTypeService;

	//@RequestMapping(path="/list",method=RequestMethod.GET)
	//@ResponseBody()
	//public List<CurCourse> listCourses(){
	//不能直接返回pojo，会出现no session的异常。


	@RequestMapping(value="/list")
	public String listCourses(Model model){

		List<CurCourseDto> courseDto = courseService.list();//调用service层的方法实现业务逻辑.

		model.addAttribute("courseDto", courseDto);//将数据放到model，传输给页面

		return "/admin/course/course_list";
	}


	@RequestMapping(value="/add/list")
	public String addList(Model model){
		//		String courseHsql="from CurCourse";
		//		String teacherHsql = "from CurTeacher";
		//		String typeHsql = "from CurType";
		//		
		//		CurCourse curCourse=courseService.get(curId);
		//		CurType curType=courseType.get(curCourse.getCurType().getId());
		//		CurTeacher curTeacher=courseTeacher.get(curCourse.getCurTeacher().getId());

		List<CurTeacherDto> teachers = courseTeacherService.list();
		List<CurTypeDto> types = courseTypeService.list();


		model.addAttribute("teachers",teachers);
		model.addAttribute("types",types);
		return "/admin/course/add";
	}


	@RequestMapping(value="/edit/list")
	public String editList(Model model,Integer curId){
		String courseHsql="from CurCourse";
		String teacherHsql = "from CurTeacher";
		String typeHsql = "from CurType";

		CurCourse curCourse=courseService.get(curId);
		CurType curType=courseTypeService.get(curCourse.getCurType().getId());
		CurTeacher curTeacher=courseTeacherService.get(curCourse.getCurTeacher().getId());

		List<CurTeacher> teachers = courseTeacherService.list(teacherHsql);
		List<CurType> types = courseTypeService.list(typeHsql);

		model.addAttribute("cur", curCourse);
		model.addAttribute("teacher",curTeacher);
		model.addAttribute("teachers",teachers);
		model.addAttribute("type",curType);
		model.addAttribute("types",types);
		return "/admin/course/edit";
	}

	@RequestMapping(value="/edit")
	public String edit(CurCourseDto courseDto,Integer teacherId,Integer typeId,Model model){
		
		System.out.println(teacherId+","+typeId);
		System.out.println(courseDto.getId());
		if(courseDto==null){
			System.out.println("---------null------------");
		}
		CurCourse curCourse = new CurCourse();
		BeanUtils.copyProperties(courseDto, curCourse);
		CurType curType=courseTypeService.get(typeId);
		CurTeacher curTeacher=courseTeacherService.get(teacherId);
		curCourse.setCurType(curType);
		curCourse.setCurTeacher(curTeacher);
		courseService.update(curCourse);

		model.addAttribute("message", "你的课程信息修改成功！");
		model.addAttribute("nextPageName", "课程管理功能");
		model.addAttribute("nextUrl", "/course/list");
		return "/admin/result";
	}

	@RequestMapping(value="/add")
	public String add(CurCourseDto courseDto,String teacherName,String courseType,Model model){
		System.out.println(teacherName+","+courseType);
		System.out.println(courseDto.getId());
		if(courseDto==null){
			System.out.println("---------null------------");
		}
		CurCourse curCourse = new CurCourse();
		BeanUtils.copyProperties(courseDto, curCourse);
		/*CurType curType=courseType.get(typeId);
		CurTeacher curTeacher=courseTeacher.get(teacherId);
		curCourse.setCurType(curType);
		curCourse.setCurTeacher(curTeacher);*/
		courseService.save(curCourse);

		model.addAttribute("message", "你的课程信息添加成功！");
		model.addAttribute("nextPageName", "课程管理功能");
		model.addAttribute("nextUrl", "/course/list");
		return "/admin/result";
	}
	@RequestMapping(value="/del")
	public String delete(Integer curId,Model model){

		courseService.deleteById(curId);
		model.addAttribute("message", "你的课程信息删除成功！");
		model.addAttribute("nextPageName", "课程管理功能");
		model.addAttribute("nextUrl", "/course/list");
		return "/admin/result";
	}


	//保存课程功能
	@RequestMapping("/saveCourse")
	@ResponseBody // 返回json数据
	public ResponseDto saveCourse(CurCourseDto course,String teacherName,String courseType){
		ResponseDto response = new ResponseDto();
		Session session=courseService.getSession();
		try {
			Criteria teacherCriteria = session.createCriteria(CurTeacher.class);
			teacherCriteria.add(Restrictions.like("name", teacherName, MatchMode.ANYWHERE));
			Criteria typeCriteria = session.createCriteria(CurTeacher.class);
			typeCriteria.add(Restrictions.like("name", courseType, MatchMode.ANYWHERE));
			CurTeacher curTeacher = (CurTeacher)teacherCriteria.setResultTransformer(Transformers.aliasToBean(CurTeacher.class));
			CurType curType = (CurType)teacherCriteria.setResultTransformer(Transformers.aliasToBean(CurType.class));
			System.out.println(curTeacher.getName()+curType.getName());
			CurCourse curCourse = new CurCourse();
			BeanUtils.copyProperties(course, curCourse);
			curCourse.setCurType(curType);
			curCourse.setCurTeacher(curTeacher);
			courseService.save(curCourse);
			if(course.equals(null)){
				System.out.println("-----------------null--------------------");
			}

			response.setCode("200");
			response.setMessage("保存成功");
		} catch (Exception e) {
			response.setCode("422");
			response.setMessage("保存失败:"+e.getMessage());
		} finally {
			session.close();
		}

		return response;
	}
}
