package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.beans.InformationType;
import com.cms.dto.InformationTypeDto;
import com.cms.dto.KnowledgeTypeDto;
import com.cms.dto.ResponseDto;
import com.cms.services.IInformationTypeService;

@Controller
@RequestMapping(value = "/informationType")
public class InformationTypeController {

	@Autowired
	private IInformationTypeService informationTypeService;

	@RequestMapping("/toList")
	public String toList() {
		return "/admin/information/informationType_list";
	}

	// 提供接口方法，返回jsonsh数据給請求端
	@RequestMapping("/list")
	@ResponseBody // 返回json数据
	public List<InformationTypeDto> list() {

		List<InformationTypeDto> list = informationTypeService.list();
		for (InformationTypeDto InformationType : list) {
			System.out.println(InformationType);
		}
		return list;
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add(Model model) {
		return null;
	}

	// 添加资讯类型
	@RequestMapping("/save")
	@ResponseBody
	public ResponseDto savaInformationType(InformationTypeDto informationTypeDto) {
		ResponseDto response = new ResponseDto();
		try {
			informationTypeService.save(informationTypeDto);

			response.setCode("200");
			response.setMessage("添加成功!");
		} catch (Exception e) {
			response.setCode("422");
			response.setMessage("添加失败!" + e.getMessage());
		}
		return response;
	}

	// 删除资讯类型
	@RequestMapping("/delete")
	@ResponseBody
	public ResponseDto deleteInformationType(Integer it_id) {
		ResponseDto response = new ResponseDto();
		try {
			InformationType informationType = informationTypeService.get(it_id);
			informationTypeService.delete(informationType);

			response.setCode("200");
			response.setMessage("删除成功!");
		} catch (Exception e) {
			response.setCode("422");
			response.setMessage("删除失败,Caused by:" + e.getMessage());
		}
		return response;
	}
}
