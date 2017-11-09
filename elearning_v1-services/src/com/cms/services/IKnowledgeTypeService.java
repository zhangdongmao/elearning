package com.cms.services;

import java.util.List;

import com.cms.beans.KnowledgeType;
import com.cms.dto.KnowledgeTypeDto;

public interface IKnowledgeTypeService extends IBaseService<KnowledgeType>{
	List<KnowledgeTypeDto> list();
}
