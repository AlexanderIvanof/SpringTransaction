package com.alex.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alex.spring.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

	@Query("select count(c) from Contact c")
	public Long countAll();
}
