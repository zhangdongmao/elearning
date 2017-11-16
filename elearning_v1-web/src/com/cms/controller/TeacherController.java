package com.cms.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
@RequestMapping(value = "/teacher")
public class TeacherController {
	// controller如果能够得到service实例，就表明spring的MVC和service已经集成成功.
	@Autowired
	private ICurTeacherService teacherService;
	@Autowired
	private IUacRoleService uacRoleService;
	@Autowired
	private IUacUserinforService uacUserinforService;

	// ..................教师表查询................
	@RequestMapping(value = "/list")
	public String listTeacher(Model model) {

		String hsql = "from CurTeacher";
		List<CurTeacher> teacher = teacherService.list(hsql);// 调用service层的方法实现业务逻辑.

		for (int i = 0; i < teacher.size(); i++) {

			System.out.println(teacher.get(i));
		}

		model.addAttribute("teacher", teacher);// 将数据放到model，传输给页面

		return "/admin/teacher/teacher_list";
	}

	// .............................添加数据.......................
	@RequestMapping(value = "/add/list")
	public String addList(Model model) {
		List<UacRoleDto> roles = uacRoleService.list();
		List<UacUserinforDto> user = uacUserinforService.list();

		model.addAttribute("role", roles);
		model.addAttribute("users", user);

		return "/admin/teacher/add";
	}

	// 保存讲师信息功能
	@RequestMapping("/saveTeacher")
	@ResponseBody // 返回json数据
	public ResponseDto saveTeacher(HttpServletRequest request, CurTeacherDto teacher, String role,
			String userInfor) throws Exception {
		// 文件上传，真正的实例是MultipartHttpServletRequest
		MultipartHttpServletRequest upload = (MultipartHttpServletRequest) request;
		System.out.println("-----------------pass-----------------------");
		ResponseDto response = new ResponseDto();
		String fileName = "";
		try {
			// 获取上传的文件
			Map<String, MultipartFile> fileMap = upload.getFileMap();
			MultipartFile curImage = fileMap.get("teacherPhoto");// key就是表单input的名
			String filePath = request.getServletContext().getRealPath("upload");
			fileName = (new Date()).getTime()
					+ curImage.getOriginalFilename().substring(curImage.getOriginalFilename().lastIndexOf("."));

			String fileSavePath = filePath + "/" + fileName;


			// 保存文件
			curImage.transferTo(new File(fileSavePath));
		} catch (Exception e) {
			e.printStackTrace();

		}

		// 获取文件保存路径
		try {
			String roleHsql = "from UacRole t where t.name=?";
			String userHsql = "from UacUserinfor c where c.nickname=?";
			List<UacRole> roles = uacRoleService.find(roleHsql, role);
			List<UacUserinfor> users = uacUserinforService.find(userHsql, userInfor);
			UacRole uacRole = roles.get(0);
			UacUserinfor uacUserinfor = users.get(0);
			System.out.println(uacRole.getName());
			System.out.println(uacUserinfor.getNickname());
			CurTeacher curTeacher = new CurTeacher();
			BeanUtils.copyProperties(teacher, curTeacher);
			curTeacher.setTeacherPhoto(fileName);
			curTeacher.setUacRole(uacRole);
			curTeacher.setUacUserinfor(uacUserinfor);
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

	

	// ...............删除............................
	@RequestMapping(value = "/del")
	public String delete(Integer curId, Model model) {

		teacherService.deleteById(curId);
		model.addAttribute("message", "你的课程信息删除成功！");
		model.addAttribute("nextPageName", "课程管理功能");
		model.addAttribute("nextUrl", "/teacher/list");
		return "/admin/result";
	}

	// ....................编辑..............................
	@RequestMapping(value = "/edit/list")
	public String editList(Model model, Integer curId) {

		String uacRoleHsql = "from UacRole";
		String teacherHsql = "from CurTeacher";
		String uacUserinforHsql = "from UacUserinfor";

		CurTeacher curTeacher = teacherService.get(curId);

		UacRole uacRole = uacRoleService.get(curTeacher.getUacRole().getId());

		UacUserinfor Userinfor = uacUserinforService.get(curTeacher.getUacUserinfor().getId());
		System.out.println(curTeacher.getPassword());
		List<UacRole> roles = uacRoleService.list(uacRoleHsql);
		List<UacUserinfor> user = uacUserinforService.list(uacUserinforHsql);

		model.addAttribute("cur", curTeacher);
		model.addAttribute("role", uacRole);
		model.addAttribute("user", Userinfor);
		model.addAttribute("roles", roles);
		model.addAttribute("users", user);
		return "/admin/teacher/edit";

	}

	@RequestMapping(value = "/edit")
	public String edit(@RequestParam("photo") CommonsMultipartFile upload, HttpSession session,
			CurTeacherDto curTeacherDto, Integer roleId, Integer userId, Model model) {

		String onlyName = "";
		try {
			// 得到原始的文件名
			String fileName = upload.getOriginalFilename();
			// 得到文件的后缀名
			String extendName = fileName.substring(fileName.lastIndexOf("."));
			// 重写命名为唯一的文件名
			onlyName = UUID.randomUUID().toString() + extendName;
			// 得到上传到服务器上的图片文件夹的全路径:
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

		System.out.println(roleId + "," + userId);
		System.out.println(curTeacherDto.getPassword());
		CurTeacher curTeacher = new CurTeacher();
		BeanUtils.copyProperties(curTeacherDto, curTeacher);
		UacRole uacRole = uacRoleService.get(roleId);
		UacUserinfor uacUserinfor = uacUserinforService.get(userId);
		curTeacher.setUacRole(uacRole);
		curTeacher.setUacUserinfor(uacUserinfor);
		curTeacher.setTeacherPhoto(onlyName);
		teacherService.update(curTeacher);

		model.addAttribute("message", "你的课程信息修改成功！");
		model.addAttribute("nextPageName", "课程管理功能");
		model.addAttribute("nextUrl", "/teacher/list");
		return "/admin/result";
	}

}
