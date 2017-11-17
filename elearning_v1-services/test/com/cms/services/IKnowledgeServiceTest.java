package com.cms.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cms.dto.KnowledgeDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class IKnowledgeServiceTest {
	
	@Autowired
	IKnowledgeService service;
	
	@Test
	public void test() {
		List<KnowledgeDto> list = service.list();
		for (KnowledgeDto knowledgeDto : list) {
			System.out.println(knowledgeDto.toString());
		}
	}

}
