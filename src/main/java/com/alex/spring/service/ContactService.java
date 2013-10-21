package com.alex.spring.service;

import java.util.List;

import com.alex.spring.entity.Contact;

public interface ContactService {
	public List<Contact> findAll();
	public Contact findById(Long id);
	public Contact save(Contact contact);
	public long countAllRows();

}
