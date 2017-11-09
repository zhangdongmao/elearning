package com.cms.controller;

import java.util.List;

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
import com.cms.services.ICurTeacherService;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
	//controller如果能够得到service实例，就表明spring的MVC和service已经集成成功.
	@Autowired
	private ICurTeacherService teacherService;
	
	

//..................教师表查询................
	@RequestMapping(value="/list")
	public String listTeacher(Model model){
		
		String hsql="from CurTeacher";
		List<CurTeacher> teacher = teacherService.list(hsql);//调用service层的方法实现业务逻辑.


		for (int i = 0; i < teacher.size(); i++) {

			System.out.println(teacher.get(i));
		}
		
		model.addAttribute("teacher", teacher);//将数据放到model，传输给页面

		return "/admin/teacher/teacher_list";
	}
	
	//添加数据
	@RequestMapping("/saveTeacher")
	@ResponseBody // 返回json数据
	public CurTeacherDto saveTeacher(CurTeacher teacher){
		CurTeacherDto response = new CurTeacherDto();
		try {
			teacherService.save(teacher);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return response;
		
		
	}
	
	//...............删除............................
	@RequestMapping(value="/del")
	public String delete(Integer curId,Model model){

		teacherService.deleteById(curId);
		model.addAttribute("message", "你的课程信息删除成功！");
		model.addAttribute("nextPageName", "课程管理功能");
		model.addAttribute("nextUrl", "/teacher/list");
		return "/admin/result";
	}
	
	
	
	
}
