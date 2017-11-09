package com.cms.services;

import java.util.List;

import com.cms.beans.Knowledge;
import com.cms.dto.KnowledgeDto;

public interface IKnowledgeService extends IBaseService<Knowledge>{
	List<KnowledgeDto> list();
}
