package com.alex.spring.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.entity.Contact;
import com.alex.spring.service.ContactService;

public class CustomerTest {

	private GenericXmlApplicationContext appCont;
	private ContactService service;
	
	@Before
	public void initContext(){
		appCont = new GenericXmlApplicationContext();
		appCont.load("classpath:ctxt/tx-anno-ctx.xml");
		appCont.refresh();
		
		service = appCont.getBean("contactService", ContactService.class);
	}
	
	@Test
	@Ignore
	public void contactListTest() {
		List<Contact> list = service.findAll();
		assertNotNull(list);
	}
	
	@Test
	@Ignore
	public void findAndUpdateContactTest(){
		Contact cntct = service.findById(2l);
		cntct.setFirstName("PETER");
		service.save(cntct);
	}
	
	@Test
	public void countAccountTest(){
		long l = service.countAllRows();
		System.out.println(l);
		assertEquals(3L, l);
	}

}
