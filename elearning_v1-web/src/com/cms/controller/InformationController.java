package com.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cms.beans.Information;
import com.cms.beans.InformationType;
import com.cms.dto.CurCourseDto;
import com.cms.dto.InformationDto;
import com.cms.dto.InformationTypeDto;
import com.cms.dto.ResponseDto;
import com.cms.services.IInformationService;
import com.cms.services.IInformationTypeService;

@Controller
@RequestMapping(value = "/information")
public class InformationController {

	@Autowired
	private IInformationService inforService;

	@Autowired
	private IInformationTypeService itService;

	@RequestMapping("/list")
	public String listInformation(Model model) {
		// 查询资讯类型表，为了得到资讯类型的id，根据id得到资讯类型的名称
		String hql = "from Information";
		List<Information> infor = inforService.list(hql);
		InformationType it = itService.get(infor.get(0).getInformationType().getId());
		String itName = it.getName();
		// 直接传到前台，不需要通过咨询表调用
		model.addAttribute("itName", itName);
		model.addAttribute("infor", infor);
		return "/admin/information/information_list";
	}

	@RequestMapping("/add")
	public String saveInofrmation(Model model) {
		List<InformationTypeDto> itDtos = itService.list();
		List<InformationDto> ifDtos = inforService.list();

		model.addAttribute("itDtos", itDtos);
		model.addAttribute("ifDtos", ifDtos);
		return "/admin/information/information_add";
	}

	// 处理异常
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView handleException(Exception e) throws Exception {
		return new ModelAndView("upload_file").addObject("messge", "文件太大！");
	}

	@RequestMapping("/save")
	public String save(@RequestParam("iPhoto") CommonsMultipartFile upload, Model model, HttpSession session,
			InformationDto inforDto, String itName) throws Exception {
		String onlyName = "";
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
		// 查询资讯类型，得到类型的名字并传到前端
		String hql = "from InformationType it where it.name=?";
		List<InformationType> informationTypes = itService.find(hql, itName);
		// 得到资讯类型
		InformationType it = informationTypes.get(0);

		Information infor = new Information();
		BeanUtils.copyProperties(infor, infor);
		// 给照片设定不重复的名字
		infor.setPhoto(onlyName);
		infor.setInformationType(it);

		inforService.save(infor);

		model.addAttribute("message", "添加成功!");
		model.addAttribute("nextPageName", "资讯表");
		model.addAttribute("nextUrl", "/information/list");
		return "/admin/result";
	}

	@RequestMapping("/del")
	public String delInformation(Integer infor_id, Model model) {
		inforService.deleteById(infor_id);

		model.addAttribute("message", "删除成功!");
		model.addAttribute("nextPageName", "资讯表");
		model.addAttribute("nextUrl", "/information/list");
		return "/admin/result";
	}
}
