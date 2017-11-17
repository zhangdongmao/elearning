package com.cms.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.beans.Knowledge;
import com.cms.beans.KnowledgeType;
import com.cms.dto.KnowledgeDto;
import com.cms.dto.KnowledgeTypeDto;
import com.cms.dto.ResponseDto;
import com.cms.services.IKnowledgeService;
import com.cms.services.IKnowledgeTypeService;

@Controller
@RequestMapping(value = "/knowledge")
public class KnowledgeControllor {

	@Autowired
	private IKnowledgeService knowledgeService;
	
	// 增加方法，转发到列表页,目的是为了隐藏jsp路径，避免直接访问
		@RequestMapping("/toknowledgeList")
		public String toknowledgeList() {
			return "/admin/knowledge/knowledge_list";
		}
		
		@RequestMapping(value = "/list")
		@ResponseBody
		public List<KnowledgeDto> listKnoweledge() {
			List<KnowledgeDto> kl = knowledgeService.list();// 调用service层的方法实现业务逻辑.
			return kl;
		}
		
		// 保存知识功能
		@RequestMapping("/saveKnowledge")
		@ResponseBody // 返回json数据
		public ResponseDto saveKl(KnowledgeDto kld) {
			System.out.println("=================save====================");
			ResponseDto response = new ResponseDto();
			try {
				Knowledge knowledge=new Knowledge();
				BeanUtils.copyProperties(kld, knowledge);
				knowledgeService.save(knowledge);
				
				response.setCode("200");
				response.setMessage("保存成功");
			} catch (Exception e) {
				e.printStackTrace();
				response.setCode("422");
				response.setMessage("保存失败:" + e.getMessage());
			}

			return response;
		}
		
		
		
		// 删除功能
		@RequestMapping("/del")
		@ResponseBody
		public ResponseDto delete(Integer klId) {
			ResponseDto response = new ResponseDto();
			// 删除的步骤: 1.根据id从数据库获取数据 2.删除数据
			try {
				/*
				 * InformationType kt = knowledgeTypeService.get(klId);
				 * knowledgeTypeService.delete(kt);
				 */
				knowledgeService.deleteById(klId);
				response.setCode("200");
				response.setMessage("删除成功");
			} catch (Exception e) {
				response.setCode("422");
				response.setMessage("删除失败:" + e.getMessage());
			}

			return response;
		}
	
	

}
