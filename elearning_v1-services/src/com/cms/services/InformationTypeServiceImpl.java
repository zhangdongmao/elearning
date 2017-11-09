package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.InformationType;
import com.cms.dao.IInformationTypeDao;
import com.cms.dto.CurCourseDto;
import com.cms.dto.InformationTypeDto;

@Service
public class InformationTypeServiceImpl extends BaseServiceImpl<InformationType> implements IInformationTypeService {

	private IInformationTypeDao informationTypeDao;

	@Autowired
	public void setInformationDao(IInformationTypeDao informationTypeDao) {
		this.informationTypeDao = informationTypeDao;
		this.setBaseDao(informationTypeDao);
	}

	@Override
	public List<InformationTypeDto> list() {
		String hsql = "from InformationType";
		List<InformationType> informationTypes = this.list(hsql);

		if (informationTypes == null) {
			System.out.println("-----null-----");
		}

		List<InformationTypeDto> informationTypeDtos = new ArrayList();

		for (int i = 0; i < informationTypes.size(); i++) {
			InformationTypeDto informationTypeDto = new InformationTypeDto();
			BeanUtils.copyProperties(informationTypes.get(i), informationTypeDto);
			informationTypeDtos.add(informationTypeDto);
		}
		return informationTypeDtos;
	}

	@Override
	public void save(InformationTypeDto informationTypeDto) {
			InformationType informationType=new InformationType();
			BeanUtils.copyProperties(informationTypeDto, informationType);
			this.save(informationType);
	}

}
