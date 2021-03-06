package com.cms.services;

import java.util.List;

import com.cms.beans.KnowledgeType;
import com.cms.dto.CurCourseDto;
import com.cms.dto.KnowledgeTypeDto;

public interface IKnowledgeTypeService extends IBaseService<KnowledgeType>{
	List<KnowledgeTypeDto> list();
	
	void update(KnowledgeTypeDto knowledgeTypeDto);
	
	void save (KnowledgeTypeDto knowledgeTypeDto);
}
