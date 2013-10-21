package com.alex.spring.service.jta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.spring.entity.Contact;
import com.alex.spring.service.ContactService;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	@PersistenceContext(unitName = "emfA")
	private EntityManager emA;
	
	@PersistenceContext(unitName = "emfB")
	private EntityManager emB;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Contact findById(Long id) {
		return null;
	}

	@Override
	public Contact save(Contact contact) {
		Contact cnt = new Contact();
		cnt.setFirstName(contact.getFirstName());
		cnt.setLastName(contact.getLastName());
		
		if(cnt.getId() == null){
			emA.persist(contact);
			emB.persist(cnt);
		} else {
			emA.merge(contact);
			emB.merge(contact);
		}
		return null;
	}

	@Override
	public long countAllRows() {
		return 0;
	}

}
