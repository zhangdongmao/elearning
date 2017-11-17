package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cms.beans.UacRole;
import com.cms.dao.IUacRoleDao;
import com.cms.dto.UacRoleDto;

@Service
public class UacRoleServiceImpl extends BaseServiceImpl<UacRole> implements IUacRoleService{
	
	private IUacRoleDao iUacRoleDao;

	public void setiUacRoleDao(IUacRoleDao iUacRoleDao) {
		this.iUacRoleDao = iUacRoleDao;
		this.setBaseDao(iUacRoleDao);
	}

	@Override
	public List<UacRoleDto> list() {
		String hsql="from UacRole";
		List<UacRole> role=this.list(hsql);

		if(role==null){
			System.out.println("-------------null------------------");
		}
		//将pojo的数据转换成dto，使用BeanUtils.copyProperties 可以简化
		List<UacRoleDto> roleDtos = new ArrayList();
		for (int i = 0; i < role.size(); i++) {
			UacRoleDto uacRoleDto=new UacRoleDto();
			BeanUtils.copyProperties(role.get(i), uacRoleDto);
			roleDtos.add(uacRoleDto);
		}
		
       
		return roleDtos;
	}

	@Override
	public void update(UacRoleDto uacRoleDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(UacRoleDto uacRoleDto) {
		// TODO Auto-generated method stub
		
	}

}
