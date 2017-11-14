package com.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cms.beans.CurTeacher;
import com.cms.beans.UacRole;
import com.cms.beans.UacUserinfor;
import com.cms.dto.CurTeacherDto;
import com.cms.dto.ResponseDto;
import com.cms.dto.UacRoleDto;
import com.cms.dto.UacUserinforDto;
import com.cms.services.ICurTeacherService;
import com.cms.services.IUacRoleService;
import com.cms.services.IUacUserinforService;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
	//controller如果能够得到service实例，就表明spring的MVC和service已经集成成功.
	@Autowired
	private ICurTeacherService teacherService;
	@Autowired
	private IUacRoleService uacRoleService;
	@Autowired
	private IUacUserinforService uacUserinforService;
	

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
	
	//.............................添加数据.......................
	@RequestMapping(value="/add/list")
	public String addList(Model model){
		List<UacRoleDto> roles = uacRoleService.list();
		List<UacUserinforDto> user = uacUserinforService.list();
		for (UacUserinforDto uacUserinforDto : user) {
			System.out.println(uacUserinforDto.getNickname());
		}
		
		model.addAttribute("role",roles);
		model.addAttribute("users",user);
		return "/admin/teacher/add";
	}
	
	
	
	//保存讲师信息功能
		@RequestMapping("/saveTeacher")
		@ResponseBody // 返回json数据
		public ResponseDto saveCourse(HttpServletRequest request, HttpSession session, CurTeacherDto teacher,String roleName,String userType) throws Exception{
			System.out.println("-----------------pass-----------------------");
			
			ResponseDto response = new ResponseDto();
			
			
			if (request instanceof MultipartHttpServletRequest) {
				System.out.println("-----------------pass2-----------------------");
				MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;

				// 普通表单数据
				Map<String, String[]> dataMap = mulRequest.getParameterMap();
				String[] userName = dataMap.get("userName");
				System.out.println("----userName----" + userName);

				// 文件表单数据 -- 不管多少个文件，都通过次对象获取。key是表单的名字
				Map<String, MultipartFile> fileMap = mulRequest.getFileMap();
				
				MultipartFile file1 = fileMap.get("teacherPhoto");
				MultipartFile file2 = fileMap.get("file2");

				// 文件保存路径
				String realPath = request.getServletContext().getRealPath("/upload");
				File fileSave = new File(realPath, file1.getOriginalFilename());

				file1.transferTo(fileSave);

				String imgePath = "upload/" + file1.getOriginalFilename();

				
			}
			
			
			// 获取文件保存路径
			try {
				String roleHsql="from UacRole t where t.name=?";
				String userHsql="from UacUserinfor c where c.nickname=?";
				List<UacRole> roles = uacRoleService.find(roleHsql,roleName);
				List<UacUserinfor> users = uacUserinforService.find(userHsql,userType);
				UacRole uacRole = roles.get(0);
				UacUserinfor uacUserinfor = users.get(0);
				System.out.println(uacRole.getName());
				System.out.println(uacUserinfor.getNickname());
				CurTeacher curTeacher= new CurTeacher();
				BeanUtils.copyProperties(teacher, curTeacher);
				curTeacher.setUacRole(uacRole);
				curTeacher.setUacUserinfor(uacUserinfor);
			//	curCourse.setCurPhoto(photoName);
				teacherService.save(curTeacher);
				response.setCode("200");
				response.setMessage("保存成功");
			} catch (Exception e) {
				e.printStackTrace();
				response.setCode("422");
				response.setMessage("保存失败:");
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
	
	
	//....................编辑..............................
	@RequestMapping(value="/edit/list")
	public String editList(Model model,Integer curId){
		
		
		String uacRoleHsql="from UacRole";
		String teacherHsql = "from CurTeacher";
		String uacUserinforHsql = "from UacUserinfor";

		CurTeacher curTeacher=teacherService.get(curId);
		
		UacRole uacRole=uacRoleService.get(curTeacher.getUacRole().getId());
		
		UacUserinfor Userinfor=uacUserinforService.get(curTeacher.getUacUserinfor().getId());
	   System.out.println(curTeacher.getPassword());
		List<UacRole> roles = uacRoleService.list(uacRoleHsql);
		List<UacUserinfor> user = uacUserinforService.list(uacUserinforHsql);
			
		model.addAttribute("cur", curTeacher);
		model.addAttribute("role",uacRole);
		model.addAttribute("user",Userinfor);
		model.addAttribute("roles",roles);
		model.addAttribute("users",user);
		return "/admin/teacher/edit";
	
		
	}
	
	@RequestMapping(value="/edit")
	public String edit(CurTeacherDto curTeacherDto,Integer roleId,Integer userId,Model model){
		
		System.out.println(roleId+","+userId);
		System.out.println(curTeacherDto.getId());
		System.out.println(curTeacherDto.getPassword());
		CurTeacher curTeacher = new CurTeacher();
		BeanUtils.copyProperties(curTeacherDto, curTeacher);
		UacRole uacRole=uacRoleService.get(roleId);
		UacUserinfor uacUserinfor= uacUserinforService.get(userId);
		curTeacher.setUacRole(uacRole);
		curTeacher.setUacUserinfor(uacUserinfor);
		teacherService.update(curTeacher);
	
		model.addAttribute("message", "你的课程信息修改成功！");
		model.addAttribute("nextPageName", "课程管理功能");
		model.addAttribute("nextUrl", "/teacher/list");
		return "/admin/result";
	}

	
	
}
