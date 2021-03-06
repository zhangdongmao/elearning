package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cms.beans.Knowledge;
import com.cms.beans.KnowledgeType;
import com.cms.dao.IKnowledgeDao;
import com.cms.dto.KnowledgeDto;
import com.cms.dto.KnowledgeTypeDto;

@Service
public class KnowledgeServiceImpl extends BaseServiceImpl<Knowledge> implements IKnowledgeService {

	private IKnowledgeDao Knowledge;

	@Autowired
	public void setKnowledgeDao(IKnowledgeDao knowledgeDto) {
		this.Knowledge = knowledgeDto;
		this.setBaseDao(knowledgeDto);
	}
	
	@Override
	public List<KnowledgeDto> list() {
		String hsql = "from Knowledge";
		
		// 获取数据
		List<Knowledge> knowledge = this.list(hsql);
		
		if (knowledge == null) {
			System.out.println("-------------null------------------");
		}
		
		// 将pojo的数据转换成dto，使用BeanUtils.copyProperties 可以简化
		List<KnowledgeDto> knowledgeDtos = new ArrayList();
		for (int i = 0; i < knowledge.size(); i++) {
			KnowledgeDto knowledgeDto = new KnowledgeDto();
			BeanUtils.copyProperties(knowledge.get(i), knowledgeDto);
			knowledgeDto.setKtname(knowledge.get(i).getKnowledgeType().getName());
			knowledgeDto.setNickname(knowledge.get(i).getUacUserinfor().getNickname());
			knowledgeDtos.add(knowledgeDto);
		}
		System.out.println(knowledgeDtos);
		return knowledgeDtos;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(KnowledgeDto knowledgeDto) {
		KnowledgeDto knowledge = new KnowledgeDto();
		BeanUtils.copyProperties(knowledgeDto, knowledge);
		this.update(knowledge);
	}

	@Override
	public void save(KnowledgeDto knowledgeDto) {
		Knowledge knowledge = new Knowledge();
		BeanUtils.copyProperties(knowledgeDto, knowledge);
		this.save(knowledge);
	}

}









