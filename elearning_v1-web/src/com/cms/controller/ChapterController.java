package com.cms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.beans.CurChapter;
import com.cms.dto.CurChapterDto;
import com.cms.services.ICurChapterService;

@Controller
@RequestMapping(value="/chapter")
public class ChapterController {
	
	@Autowired
	ICurChapterService chapterService;
	
	@RequestMapping(value="/list")
	@ResponseBody
	public List<String> list(Integer cuId){
		System.out.println("----------pass------------------");
		String hql="from CurChapter c where c.curCourse.id=?";
		List<CurChapter> chapters=chapterService.find(hql,cuId);
				/*chapterService.find(hql, cuId);*/
		List<String> chapterNames=new ArrayList<String>();
		for (CurChapter curChapter : chapters) {
			System.out.println(curChapter.getChapterName());
			chapterNames.add(curChapter.getChapterName());
		}

		
		return chapterNames;
		
	}
}
