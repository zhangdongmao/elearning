package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.Information;
import com.cms.beans.InformationType;
import com.cms.dao.IInformationDao;
import com.cms.dto.InformationDto;
import com.cms.dto.InformationTypeDto;

@Service
public class InformationServiceImpl extends BaseServiceImpl<Information> implements IInformationService {

	private IInformationDao informationDao;
	
	@Autowired
	public void setInformationDao(IInformationDao informationDao) {
		this.informationDao = informationDao;
		this.setBaseDao(informationDao);
	}


	@Override
	public List<InformationDto> list() {
		String hsql="from Information";
		
		List<Information> informations=this.list(hsql);
		if(informations==null){
			System.out.println("-----null-----");
		}
		
		List<InformationDto> informationDtos=new ArrayList();
		for (Information information : informations) {
			InformationDto ifDto=new InformationDto();
			BeanUtils.copyProperties(informations, ifDto);
			informationDtos.add(ifDto);
		}
		return informationDtos;
	}

}
