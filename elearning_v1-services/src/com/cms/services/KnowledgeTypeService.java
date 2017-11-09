package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.KnowledgeType;
import com.cms.dao.IKnowledgeTypeDao;
import com.cms.dto.KnowledgeTypeDto;

@Service
public class KnowledgeTypeService extends BaseServiceImpl<KnowledgeType> implements IKnowledgeTypeService {

	private IKnowledgeTypeDao KnowledgeType;

	@Autowired
	public void setKnowledgeTypeDao(IKnowledgeTypeDao TypeDao) {
		this.KnowledgeType = TypeDao;
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
		System.out.println(typeDtos);
		return typeDtos;
	}

}
