package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.beans.Information;
import com.cms.services.IInformationService;

@Controller
@RequestMapping(value="/information")
public class InformationController {

	@Autowired
	private IInformationService informationService;
	
	@RequestMapping(value="/list")
	public String listInformation(Model model){
		String hsql="from Information";
		List<Information> informations=informationService.list(hsql);
		
		for (Information information : informations) {
			System.out.println(information);
		}
		
		model.addAttribute("informations",informations);
		
		return "/admin/information/information_list";
	}
}
