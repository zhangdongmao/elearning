package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cms.beans.UacUserinfor;
import com.cms.dao.IUacUserinforDao;
import com.cms.dto.UacRoleDto;
import com.cms.dto.UacUserinforDto;

@Service
public class UacUserinforServiceImpl extends BaseServiceImpl<UacUserinfor> implements IUacUserinforService{

	private IUacUserinforDao iUacUserinforDao;
	
	public void setiUacUserinforDao(IUacUserinforDao iUacUserinforDao) {
		this.iUacUserinforDao = iUacUserinforDao;
		this.setBaseDao(iUacUserinforDao);
	}

	@Override
	public List<UacUserinforDto> list() {
		String hsql="from UacUserinfor";
		List<UacUserinfor> user=this.list(hsql);
		if(user==null){
			System.out.println("-------------null------------------");
		}
		//将pojo的数据转换成dto，使用BeanUtils.copyProperties 可以简化
		List<UacUserinforDto> userDtos = new ArrayList();
		for (int i = 0; i < user.size(); i++) {
			UacUserinforDto uacUserinforDto=new UacUserinforDto();
			BeanUtils.copyProperties(user.get(i), uacUserinforDto);
			userDtos.add(uacUserinforDto);
		}
		
		return userDtos;
	}

	@Override
	public void update(UacUserinforDto uacUserinforDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(UacUserinforDto uacUserinforDto) {
		// TODO Auto-generated method stub
		
	}

}
