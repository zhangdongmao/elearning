package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.dto.InformationDto;
import com.cms.services.IInformationService;
import com.cms.services.IInformationTypeService;

@Controller
@RequestMapping(value = "/information")
public class InformationController {

	@Autowired
	private IInformationService informationService;
	
	@Autowired
	private IInformationTypeService itService;

	@RequestMapping("/list")
	public String listInformation(Model model) {

		List<InformationDto> ifDto = informationService.list();

		model.addAttribute("ifDto", ifDto);
		return "/admin/information/information_list";
	}

}
