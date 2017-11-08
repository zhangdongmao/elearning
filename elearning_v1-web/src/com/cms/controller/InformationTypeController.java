package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.beans.InformationType;
import com.cms.dto.InformationTypeDto;
import com.cms.dto.ResponseDto;
import com.cms.services.IInformationTypeService;

@Controller
@RequestMapping(value="/informationType")
public class InformationTypeController {
	
	@Autowired
	private IInformationTypeService informationTypeService;
	
	
	
	@RequestMapping("/toList")
	public String toList(){
		return "/admin/information/informationType_list";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<InformationTypeDto> listInformationType(){
		System.out.println("----------pass----------------------");
		
		List<InformationTypeDto> informationTypeDtos=informationTypeService.list();
		
		for (InformationTypeDto informationTypeDto : informationTypeDtos) {
			
			System.out.println(informationTypeDto.getId());
		}
		return informationTypeDtos;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(Model model){
		
		return null;
	}
	
	//删除资讯类型
	@RequestMapping("/delete")
	@ResponseBody
	public ResponseDto deleteInformationType(Integer it_id){
		ResponseDto response=new ResponseDto();
		try{
			InformationType informationType=informationTypeService.get(it_id);
			informationTypeService.delete(informationType);
			
			response.setCode("200");
			response.setMessage("删除成功!");
		}catch(Exception e){
			response.setCode("422");
			response.setMessage("删除失败,Caused by:"+e.getMessage());
		}
		return response;
	}
}
