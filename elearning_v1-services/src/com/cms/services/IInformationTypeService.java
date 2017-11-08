package com.cms.services;

import java.util.List;

import com.cms.beans.InformationType;
import com.cms.dto.InformationTypeDto;

public interface IInformationTypeService extends IBaseService<InformationType>{
	List<InformationTypeDto> list();
}