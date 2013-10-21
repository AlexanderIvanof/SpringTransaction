package com.alex.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.spring.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
