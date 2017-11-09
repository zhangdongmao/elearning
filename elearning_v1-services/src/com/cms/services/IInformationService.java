package com.cms.services;

import java.util.List;

import com.cms.beans.Information;
import com.cms.dto.InformationDto;

public interface IInformationService extends IBaseService<Information> {
	List<InformationDto> list();
}
