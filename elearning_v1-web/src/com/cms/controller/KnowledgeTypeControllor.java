package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.beans.KnowledgeType;
import com.cms.dto.KnowledgeTypeDto;
import com.cms.dto.ResponseDto;
import com.cms.services.IKnowledgeTypeService;

@Controller
@RequestMapping(value="/knowledgeType")
public class KnowledgeTypeControllor {
	
	@Autowired
	private IKnowledgeTypeService knowledgeType;
	@Autowired
	private IKnowledgeTypeService knowledgeTypeService;
	
	
	//增加方法，转发到列表页,目的是为了隐藏jsp路径，避免直接访问
		@RequestMapping("/toknowledgeTypeList")
		public String toknowledgeTypeList(){
			
			return "/admin/knowledge/knowledgeType_list";
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
		
		@RequestMapping(value="/del")
		@ResponseBody
		public String delete(Integer ktid,Model model){

			knowledgeTypeService.deleteById(ktid);
			model.addAttribute("message", "你的课程信息删除成功！");
			model.addAttribute("nextPageName", "知识管理功能");
			model.addAttribute("nextUrl", "/knowledgeType/list");
			return "/admin/result";
		}
		
		//删除课程功能
		/*@RequestMapping("/del")
		@ResponseBody
		public ResponseDto deleteCourse(Integer knowledgeTypeId){
			ResponseDto response = new ResponseDto();
			//删除的步骤: 1.根据id从数据库获取数据 2.删除数据
			
			try {
				KnowledgeType knowledgeType = knowledgeTypeService.get(knowledgeTypeId);
				
				knowledgeTypeService.delete(knowledgeType);
				
				response.setCode("200");
				response.setMessage("保存成功");
			} catch (Exception e) {
				response.setCode("422");
				response.setMessage("保存失败:"+e.getMessage());
			}
			
			return response;
		}
		*/
}
