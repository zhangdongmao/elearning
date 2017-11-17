package com.cms.services;

import java.util.List;

import com.cms.beans.Knowledge;
import com.cms.dto.KnowledgeDto;
import com.cms.dto.KnowledgeTypeDto;

public interface IKnowledgeService extends IBaseService<Knowledge>{
	List<KnowledgeDto> list();
	
	void update(KnowledgeDto knowledgeDto);
	
	void save (KnowledgeDto knowledgeDto);
}
