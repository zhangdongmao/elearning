package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.beans.CurCourse;
import com.cms.beans.KnowledgeType;
import com.cms.dto.KnowledgeDto;
import com.cms.dto.KnowledgeTypeDto;
import com.cms.services.IKnowledgeTypeService;
import com.cms.services.KnowledgeTypeService;

@Controller
@RequestMapping(value="/knowledgeType")
public class KnowledgeTypeControllor {
	
	@Autowired
	private IKnowledgeTypeService knowledgeType;
	
	
	//增加方法，转发到列表页,目的是为了隐藏jsp路径，避免直接访问
		@RequestMapping("/toknowledgeTypeList")
		public String toknowledgeTypeList(){
			
			return "/admin/knowledgeType/knowledgeType_list";
		}
		
		//提供接口方法，返回jsonsh数据給請求端
		@RequestMapping("/list")
		@ResponseBody // 返回json数据
		public List<KnowledgeTypeDto> list(){
			
			List<KnowledgeTypeDto> list = knowledgeType.list();
			for (KnowledgeTypeDto knowledgeType : list) {
				System.out.println(knowledgeType);
			}
			return list;
		}
		
		
}
