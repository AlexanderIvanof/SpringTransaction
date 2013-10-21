package com.alex.spring.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.entity.Contact;
import com.alex.spring.service.ContactService;

public class CustomerTest {

	private GenericXmlApplicationContext appCont;
	
	@Before
	public void initContext(){
		appCont = new GenericXmlApplicationContext();
		appCont.load("classpath:ctxt/tx-anno-ctx.xml");
		appCont.refresh();
	}
	
	@Test
	public void contactListTest() {
		ContactService service = appCont.getBean("contactService", ContactService.class);
		List<Contact> list =service.findAll();
		assertNotNull(list);
	}
	
	@Test
	public void findAndUpdateContactTest(){
		ContactService service = appCont.getBean("contactService", ContactService.class);
		Contact cntct = service.findById(2l);
		cntct.setFirstName("PETER");
		service.save(cntct);
	}

}
