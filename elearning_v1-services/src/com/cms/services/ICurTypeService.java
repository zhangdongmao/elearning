package com.cms.services;

import java.util.List;

import com.cms.beans.CurType;
import com.cms.dto.CurTypeDto;

public interface ICurTypeService extends IBaseService<CurType> {
	List<CurTypeDto> list();
}
