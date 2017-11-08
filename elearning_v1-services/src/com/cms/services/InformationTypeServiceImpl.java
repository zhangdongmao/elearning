package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.InformationType;
import com.cms.dao.IInformationTypeDao;
import com.cms.dto.InformationTypeDto;

@Service
public class InformationTypeServiceImpl extends BaseServiceImpl<InformationType> implements IInformationTypeService {

	private IInformationTypeDao informationDao;

	@Autowired
	public void setInformationDao(IInformationTypeDao informationDao) {
		this.informationDao = informationDao;
		this.setBaseDao(informationDao);
	}

	@Override
	public List<InformationTypeDto> list() {
		String hsql = "from InformationType";
		List<InformationType> informationTypes = this.list(hsql);

		if (informationTypes == null) {
			System.out.println("-----null-----");
		}

		List<InformationTypeDto> informationTypeDtos = new ArrayList();

		for (InformationType informationType : informationTypes) {
			InformationTypeDto informationTypeDto = new InformationTypeDto();
			BeanUtils.copyProperties(informationTypes, informationTypeDto);
			informationTypeDtos.add(informationTypeDto);
		}
		return informationTypeDtos;
	}

}
