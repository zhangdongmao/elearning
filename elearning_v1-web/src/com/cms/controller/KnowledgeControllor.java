package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.dto.KnowledgeDto;
import com.cms.services.IKnowledgeService;

@Controller
@RequestMapping(value = "/knowledge")
public class KnowledgeControllor {

	@Autowired
	private IKnowledgeService knowledge;

	// 增加方法，转发到列表页,目的是为了隐藏jsp路径，避免直接访问
	@RequestMapping("/toknowledgeList")
	public String toknowledgeList() {

		return "/admin/knowledge/knowledge_list";
	}

	// 提供接口方法，返回jsonsh数据給請求端
	@RequestMapping("/list")
	@ResponseBody // 返回json数据
	public List<KnowledgeDto> list() {

		List<KnowledgeDto> list = knowledge.list();
		for (KnowledgeDto knowledge : list) {
			System.out.println(knowledge);
		}
		return list;
	}

}
