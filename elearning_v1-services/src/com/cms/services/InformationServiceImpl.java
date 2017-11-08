package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.Information;
import com.cms.dao.IInformationDao;
import com.cms.dto.InformationDto;

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
			InformationDto informationDto=new InformationDto();
			BeanUtils.copyProperties(informations, informationDto);
			informationDtos.add(informationDto);
		}
		return informationDtos;
	}

}
