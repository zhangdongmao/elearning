package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.CurTeacher;
import com.cms.beans.CurType;
import com.cms.dao.ICurTypeDao;
import com.cms.dto.CurTeacherDto;
import com.cms.dto.CurTypeDto;

@Service
public class CurTypeServiceImpl extends BaseServiceImpl<CurType> implements ICurTypeService {
	
	private ICurTypeDao CurType;
	
	
	@Autowired
	public void setCourseDao(ICurTypeDao TypeDao) {
		this.CurType = TypeDao;
		this.setBaseDao(TypeDao);
	}


	@Override
	public List<CurTypeDto> list() {
		String hsql = "from CurType";
		
		//获取数据
		List<CurType> type = this.list(hsql);
		
		if(type==null){
			System.out.println("-------------null------------------");
		}
		//将pojo的数据转换成dto，使用BeanUtils.copyProperties 可以简化
		List<CurTypeDto> typeDtos = new ArrayList();
		for (int i = 0; i < type.size(); i++) {
			CurTypeDto curTypeDto=new CurTypeDto();
			//courseDto.setCode(courses.get(i).getCode());不用这么麻烦
			BeanUtils.copyProperties(type.get(i), curTypeDto);
			typeDtos.add(curTypeDto);
		}
		
		return typeDtos;
	}
	
	
}
