package com.cms.services;

import java.util.List;

import com.cms.beans.UacRole;
import com.cms.dto.UacRoleDto;

public interface IUacRoleService extends IBaseService<UacRole>{
	List<UacRoleDto> list();
	
void update(UacRoleDto uacRoleDto);
	
	void save(UacRoleDto uacRoleDto);
}
