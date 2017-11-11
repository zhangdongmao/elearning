package com.cms.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

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
	@ResponseBody // 返回json数据
	public ResponseDto saveCourse(HttpServletRequest req, CurCourseDto course,String teacherName,String courseType) throws IOException, ServletException{
		Part part = req.getPart("photo");
		ResponseDto response = new ResponseDto();
		String fileName = "";
		try {

			// 重建文件名称
			// 1:根据不同的文件类型组装出一个全新的文件名，且不能重复UUID
			fileName = UUID.randomUUID().toString();
			// 2:上传的是什么类型的文件
			String fileExtension = part.getHeader("Content-Type");
			if (fileExtension.equalsIgnoreCase("image/tiff")) {
				fileName += ".tif";
			}
			if (fileExtension.equalsIgnoreCase("image/fax")) {
				fileName += ".fax";
			}
			if (fileExtension.equalsIgnoreCase("image/gif")) {
				fileName += ".gif";
			}
			if (fileExtension.equalsIgnoreCase("image/x-icon")) {
				fileName += ".ico";
			}
			if (fileExtension.equalsIgnoreCase("image/jpeg")) {
				fileName += ".jpg";
			}
			if (fileExtension.equalsIgnoreCase("image/pnetvue")) {
				fileName += ".net";
			}
			if (fileExtension.equalsIgnoreCase("image/png")) {
				fileName += ".png";
			}
			if (fileExtension.equalsIgnoreCase("image/vnd.rn-realpix")) {
				fileName += ".rp";
			}
			if (fileExtension.equalsIgnoreCase("image/vnd.wap.wbmp")) {
				fileName += ".wbmp";
			}

			if (fileExtension.equalsIgnoreCase("image/bmp")) {
				fileName += ".bmp";
			}
			//3:文件存哪里
			String savePath = req.getServletContext().getRealPath("/upload");
			part.write(savePath + "/" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode("422");
			response.setMessage("图片上传失败!");
		}

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
			curCourse.setCurPhoto(fileName);
			courseService.save(curCourse);
			response.setCode("200");
			response.setMessage("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode("422");
			response.setMessage("保存失败:");
		} 
		
		return response;
	}
}
