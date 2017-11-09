package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.Knowledge;
import com.cms.dao.IKnowledgeDao;
import com.cms.dto.KnowledgeDto;

@Service
public class KnowledgeService extends BaseServiceImpl<Knowledge> implements IKnowledgeService {

	private IKnowledgeDao Knowledge;

	@Autowired
	public void setKnowledgeDao(IKnowledgeDao KnowledgeDto) {
		this.Knowledge = KnowledgeDto;
		this.setBaseDao(KnowledgeDto);
	}
	
	@Override
	public List<KnowledgeDto> list() {
		String hsql = "from Knowledge";
		
		// 获取数据
		List<Knowledge> Knowledge = this.list(hsql);

		if (Knowledge == null) {
			System.out.println("-------------null------------------");
		}
		// 将pojo的数据转换成dto，使用BeanUtils.copyProperties 可以简化
		List<KnowledgeDto> KnowledgeDtos = new ArrayList();
		for (int i = 0; i < Knowledge.size(); i++) {
			KnowledgeDto knowledgeDto = new KnowledgeDto();
			BeanUtils.copyProperties(Knowledge.get(i), knowledgeDto);
			KnowledgeDtos.add(knowledgeDto);
		}
		System.out.println(KnowledgeDtos);
		return KnowledgeDtos;
	}

}









