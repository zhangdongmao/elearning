package com.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

	@RequestMapping(value="/list")
	public String listCourses(Model model){

		List<CurCourseDto> courseDto = courseService.list();//调用service层的方法实现业务逻辑.

		model.addAttribute("courseDto", courseDto);//将数据放到model，传输给页面

		return "/admin/course/course_list";
	}


	@RequestMapping(value="/add/list")
	public String addList(Model model){
		List<CurTeacherDto> teachers = courseTeacherService.list();
		List<CurTypeDto> types = courseTypeService.list();
		model.addAttribute("teachers",teachers);
		model.addAttribute("types",types);
		return "/admin/course/add2";
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

	@RequestMapping(value="/del")
	public String delete(Integer curId,Model model){

		courseService.deleteById(curId);
		model.addAttribute("message", "你的知识类型删除成功！");
		model.addAttribute("nextPageName", "知识类型管理功能");
		model.addAttribute("nextUrl", "/course/list");
		return "/admin/result";
	}

	
	//保存课程功能
	@RequestMapping("/saveCourse")
	public String saveCourse(@RequestParam("photo") CommonsMultipartFile upload,
			HttpSession session, CurCourseDto course,String teacherName,String courseType) throws Exception{
		
		System.out.println(teacherName);
		System.out.println(courseType);
		System.out.println(course.getCurName());
		String onlyName="";
		try {
			// 得到原始的文件名
			String fileName = upload.getOriginalFilename();
			// 得到文件的后缀名
			String extendName = fileName.substring(fileName.lastIndexOf("."));
			// 重写命名为唯一的文件名
			onlyName = UUID.randomUUID().toString() + extendName;
			// 得到上传到服务器上的图片文件夹的全路径:C:/apache-tomcat-7.0.47/webapps/SpringMVC_001/upload
			String realyPath = session.getServletContext().getRealPath("/upload");

			File saveDir = new File(realyPath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			File saveFile = new File(saveDir, onlyName);
			upload.transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		

		
		
		// 获取文件保存路径
		try {
			String teacherHsql="from CurTeacher t where t.name=?";
			String typeHsql="from CurType c where c.name=?";
			List<CurTeacher> curTeachers = courseTeacherService.find(teacherHsql,teacherName);
			List<CurType> curTypes = courseTypeService.find(typeHsql,courseType);
			CurTeacher curTeacher = curTeachers.get(0);
			CurType curType = curTypes.get(0);
			System.out.println(curTeacher.getName());
			System.out.println(curType.getName());
			CurCourse curCourse = new CurCourse();
			BeanUtils.copyProperties(course, curCourse);
			curCourse.setCurType(curType);
			curCourse.setCurTeacher(curTeacher);
			curCourse.setCurPhoto(onlyName);
			courseService.save(curCourse);
			/*response.setCode("200");
			response.setMessage("保存成功");*/
		} catch (Exception e) {
			e.printStackTrace();
			/*response.setCode("422");
			response.setMessage("保存失败:");*/
		} 

		return "/admin/result";
	}
}
