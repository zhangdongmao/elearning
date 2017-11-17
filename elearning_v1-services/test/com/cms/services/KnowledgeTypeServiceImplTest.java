package com.cms.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cms.dao.IBaseDao;
import com.cms.dao.IKnowledgeDao;
import com.cms.dto.KnowledgeTypeDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class KnowledgeTypeServiceImplTest {

	@Autowired  
	IKnowledgeTypeService knowledgeTypeService;
	
	@Test
	public void testDelete() {
		
	}
	
	@Test
	public void testList(){
		
		try {
			List<KnowledgeTypeDto> list = knowledgeTypeService.list();
			System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("失败");
			e.printStackTrace();
			
		}
		
		
	}
	

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveT() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoad() {
		fail("Not yet implemented");
	}

	@Test
	public void testListString() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		try {
			knowledgeTypeService.deleteById(1);
			System.out.println("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("删除失败");
		}
		
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

}
