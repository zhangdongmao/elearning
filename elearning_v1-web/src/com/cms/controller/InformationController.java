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

import com.cms.beans.Information;
import com.cms.beans.InformationType;
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
//		查询资讯类型表，为了得到资讯类型的id，根据id得到资讯类型的名称
		String hql = "from Information";
		List<Information> infor = inforService.list(hql);
		InformationType it = itService.get(infor.get(0).getInformationType().getId());
		String itName = it.getName();
//		直接传到前台，不需要通过咨询表调用
		model.addAttribute("itName", itName);
		model.addAttribute("infor", infor);
		return "/admin/information/information_list";
	}
	
	@RequestMapping("/add")
	public String saveInofrmation(Model model){
		List<InformationTypeDto> itDtos=itService.list();
		List<InformationDto> ifDtos=inforService.list();
	
		model.addAttribute("itDtos",itDtos);
		model.addAttribute("ifDtos",ifDtos);
		return "/admin/information/information_add";
	}
	
	//保存课程功能
	@RequestMapping("/save")
	public String save(HttpServletRequest req, InformationDto ifDtos,String itName,Model model) throws IOException, ServletException{
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

			String itHsql="from InformationType it where it.name=?";
//			String inforHsql="from Information infor where infor.title=?";
			List<InformationType> its = itService.find(itHsql,itName);
//			List<CurType> curTypes = courseTypeService.find(typeHsql,it);
//			CurTeacher curTeacher = curTeachers.get(0);
			InformationType it = its.get(0);
//			System.out.println(curTeacher.getName());
			System.out.println(it.getName());
			
			Information infor=new Information();
			BeanUtils.copyProperties(ifDtos, infor);
			infor.setInformationType(it);
			infor.setPhoto(fileName);
			inforService.save(infor);
		
		model.addAttribute("message","添加成功!");
		model.addAttribute("nextPageName","资讯表");
		model.addAttribute("nextUrl","/information/list");
		
		return "/admin/result";
	}
	
	@RequestMapping("/del")
	public String delInformation(Integer infor_id,Model model){
		inforService.deleteById(infor_id);
		
		model.addAttribute("message","删除成功!");
		model.addAttribute("nextPageName","资讯表");
		model.addAttribute("nextUrl","/information/list");
		return "/admin/result";
	}
}
