package com.alex.spring.service.annotation;

import java.util.List;

import javax.swing.event.ListSelectionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.spring.entity.Contact;
import com.alex.spring.repository.ContactRepository;
import com.alex.spring.service.ContactService;
import com.google.common.collect.Lists;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}
	
	@Override
	@Transactional(readOnly = true)
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}
	
	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public long countAllRows() {
		// TODO Auto-generated method stub
		return 0;
	}

}
