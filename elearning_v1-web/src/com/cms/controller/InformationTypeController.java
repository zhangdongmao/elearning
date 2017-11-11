package com.cms.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.beans.InformationType;
import com.cms.dto.InformationTypeDto;
import com.cms.dto.ResponseDto;
import com.cms.services.IInformationTypeService;
/**
 * 提供前後端分離方式的後端接口：
 * 1.注意“接口概念”
 * 2.提供的功能
 *    -列出课程
 *    -获取单个课程 -- 为编辑功能提供支持 *
 *    -保存功能 -- 为编辑功能提供支持 *
 *    -提供删除功能
 * 
 */
@Controller
@RequestMapping("/informationType")
public class InformationTypeController {
	@Autowired
	IInformationTypeService itService;
	
	//增加方法，转发到列表页,目的是为了隐藏jsp路径，避免直接访问
	@RequestMapping("/toList")
	public String toList(){
		
		return "/admin/information/informationType_list";
	}
	
	//提供接口方法，返回jsonsh数据給請求端
	@RequestMapping("/list")
	@ResponseBody // 返回json数据
	public List<InformationTypeDto> list(){
		
		List<InformationTypeDto> list = itService.list();
		
		return list;
	}
	
	//保存课程功能
	@RequestMapping("/save")
	@ResponseBody // 返回json数据
	public ResponseDto save(InformationTypeDto itDto){
		ResponseDto response = new ResponseDto();
		try {
			itService.save(itDto);
			
			response.setCode("200");
			response.setMessage("保存成功");
		} catch (Exception e) {
			response.setCode("422");
			response.setMessage("保存失败:"+e.getMessage());
		}
		
		return response;
	}
	
	
	@RequestMapping("/getIT")
	@ResponseBody
	public InformationTypeDto get(Integer it_id){
		InformationType it= itService.get(it_id);
		
		InformationTypeDto itDto= new InformationTypeDto();
		BeanUtils.copyProperties(it, itDto);
		
		return itDto;
	}
	
	
	
	@RequestMapping("/update")
	@ResponseBody
	public ResponseDto update(InformationTypeDto itDto){
		
		ResponseDto response = new ResponseDto();
		try {
			//CurCourse cur= new CurCourse();
			//BeanUtils.copyProperties(course, cur);，不能直接将提交数据保存进数据库,而是先获取数据，然后只修改你修改的字段
			
			//得到数据库中最新的数据
			InformationType it= itService.get(itDto.getId());
			
			//修改页面中修改的字段，避免覆盖数据库中的其他字段的数据
			it.setName(itDto.getName());
			
			itService.update(it);
			
			response.setCode("200");
			response.setMessage("保存成功");
		} catch (Exception e) {
			response.setCode("422");
			response.setMessage("保存失败:"+e.getMessage());
		}
		return response;
	}
	
	
	//删除功能
	@RequestMapping("/del")
	@ResponseBody
	public ResponseDto delete(Integer it_id){
		ResponseDto response = new ResponseDto();
		//删除的步骤: 1.根据id从数据库获取数据 2.删除数据
		try {
			/*InformationType it = itService.get(it_Id);
			itService.delete(it);*/
			itService.deleteById(it_id);
			response.setCode("200");
			response.setMessage("删除成功");
		} catch (Exception e) {
			response.setCode("422");
			response.setMessage("删除失败:"+e.getMessage());
		}
		
		return response;
	}
}
