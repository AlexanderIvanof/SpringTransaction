package com.alex.spring.run;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.entity.Contact;
import com.alex.spring.service.ContactService;

public class TxAppRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctxt = new GenericXmlApplicationContext();
		ctxt.load("classpath:ctxt/tx-jta-app-ctx.xml");
		ctxt.refresh();
		
		ContactService service = ctxt.getBean("contactService", ContactService.class);
		
		Contact cont = new Contact();
		cont.setFirstName("JTA");
		cont.setLastName("MANAGER");
		
		service.save(cont);
		System.out.println("Saved successfully");
	}

}
