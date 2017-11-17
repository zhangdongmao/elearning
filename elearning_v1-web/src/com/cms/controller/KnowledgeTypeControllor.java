package com.cms.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.beans.KnowledgeType;
import com.cms.dto.KnowledgeTypeDto;
import com.cms.dto.ResponseDto;
import com.cms.services.IKnowledgeTypeService;

@Controller
@RequestMapping(value = "/knowledgeType")
public class KnowledgeTypeControllor {

	@Autowired
	private IKnowledgeTypeService knowledgeTypeService;

	// 增加方法，转发到列表页,目的是为了隐藏jsp路径，避免直接访问
	@RequestMapping("/toknowledgeTypeList")
	public String toknowledgeTypeList() {
		return "/admin/knowledge/knowledgeType_list";
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<KnowledgeTypeDto> listKnoweledgeType() {
		List<KnowledgeTypeDto> kt = knowledgeTypeService.list();// 调用service层的方法实现业务逻辑.
		return kt;
	}

	// 保存知识类型功能
	@RequestMapping("/saveKnowledgeType")
	@ResponseBody // 返回json数据
	public ResponseDto saveKt(KnowledgeTypeDto ktd) {
		ResponseDto response = new ResponseDto();
		try {
			KnowledgeType knowledgeType=new KnowledgeType();
			BeanUtils.copyProperties(ktd, knowledgeType);
			knowledgeTypeService.save(knowledgeType);

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
	public ResponseDto delete(Integer ktId) {
		ResponseDto response = new ResponseDto();
		// 删除的步骤: 1.根据id从数据库获取数据 2.删除数据
		try {
			/*
			 * InformationType kt = knowledgeTypeService.get(ktId);
			 * knowledgeTypeService.delete(kt);
			 */
			knowledgeTypeService.deleteById(ktId);
			response.setCode("200");
			response.setMessage("删除成功");
		} catch (Exception e) {
			response.setCode("422");
			response.setMessage("删除失败:" + e.getMessage());
		}

		return response;
	}

	@RequestMapping("/getknowledgeType")
	@ResponseBody
	public KnowledgeTypeDto getknowledgeType(Integer ktId) {
		KnowledgeType kt = knowledgeTypeService.get(ktId);
		KnowledgeTypeDto ktDto = new KnowledgeTypeDto();
		BeanUtils.copyProperties(kt, ktDto);
		return ktDto;
	}

	@RequestMapping("/update")
	@ResponseBody
	public ResponseDto updateCourse(KnowledgeTypeDto KnowledgeType) {
		ResponseDto response = new ResponseDto();
		try {
			// 得到数据库中最新的数据
			System.out.println(KnowledgeType.getName());
			KnowledgeType kt = knowledgeTypeService.get(KnowledgeType.getId());
			// 修改页面中修改的字段，避免覆盖数据库中的其他字段的数据
			kt.setName(KnowledgeType.getName());
			kt.setCode(KnowledgeType.getCode());
			knowledgeTypeService.update(kt);
			response.setCode("200");
			response.setMessage("保存成功");
		} catch (Exception e) {
			response.setCode("422");
			response.setMessage("保存失败:" + e.getMessage());
		}
		return response;
	}

	/*
	 * @RequestMapping(value="/test")
	 * @ResponseBody public List<KnowledgeTypeDto> list(int ktId){
	 * System.out.println(ktId); List<KnowledgeTypeDto> kt =
	 * knowledgeTypeService.list();//调用service层的方法实现业务逻辑. return kt; }
	 */
	/*
	 * @RequestMapping(value="/list") 
	 * public String listKnoweledgeType(Model model){ 
	 * List<KnowledgeTypeDto> kt = knowledgeTypeService.list();//调用service层的方法实现业务逻辑.
	 * model.addAttribute("kt", kt);//将数据放到model，传输给页面
	 * return "/admin/knowledge/knowledgeType_list"; 
	 * }
	 */
	/*
	 * @RequestMapping(value="/del") public String delete(int ktId){
	 * System.out.println(ktId); knowledgeTypeService.deleteById(ktId); return
	 * "/admin/knowledge/knowledgeType_list"; }
	 */
	/*
	 * @RequestMapping(value="/edit") public String update(KnowledgeType
	 * kt,Integer ktId){ System.out.println(ktId);
	 * knowledgeTypeService.update(kt); return
	 * "/admin/knowledge/knowledgeType_list"; }
	 */
}
