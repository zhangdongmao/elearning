package com.cms.services;

import java.util.List;

import com.cms.beans.UacUserinfor;
import com.cms.dto.UacUserinforDto;

public interface IUacUserinforService extends IBaseService<UacUserinfor>{
List<UacUserinforDto> list();
	
	void update(UacUserinforDto uacUserinforDto);
	
	void save(UacUserinforDto uacUserinforDto);
	
	
}
