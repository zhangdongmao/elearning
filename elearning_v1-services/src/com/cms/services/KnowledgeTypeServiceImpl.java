package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.beans.KnowledgeType;
import com.cms.dao.IKnowledgeTypeDao;
import com.cms.dto.KnowledgeTypeDto;

@Service
public class KnowledgeTypeServiceImpl extends BaseServiceImpl<KnowledgeType> implements IKnowledgeTypeService {

	private IKnowledgeTypeDao KnowledgeTypeDao;

	@Autowired
	public void setKnowledgeTypeDao(IKnowledgeTypeDao TypeDao) {
		this.KnowledgeTypeDao = TypeDao;
		this.setBaseDao(TypeDao);
	}

	@Override
	public List<KnowledgeTypeDto> list() {
		String hsql = "from KnowledgeType";

		// 获取数据
		List<KnowledgeType> type = this.list(hsql);

		if (type == null) {
			System.out.println("-------------null------------------");
		}
		// 将pojo的数据转换成dto，使用BeanUtils.copyProperties 可以简化
		List<KnowledgeTypeDto> typeDtos = new ArrayList();
		for (int i = 0; i < type.size(); i++) {
			KnowledgeTypeDto knowledgeTypeDto = new KnowledgeTypeDto();
			BeanUtils.copyProperties(type.get(i), knowledgeTypeDto);
			typeDtos.add(knowledgeTypeDto);
		}
		return typeDtos;
	}

	
	
	//===============后面还没写==================
		@Override
		@Transactional
		public void save(KnowledgeTypeDto knowledgeTypeDto) {
			KnowledgeType knowledgeType = new KnowledgeType();
			BeanUtils.copyProperties(knowledgeTypeDto, knowledgeType);
			this.save(knowledgeType);
		}
	
}
