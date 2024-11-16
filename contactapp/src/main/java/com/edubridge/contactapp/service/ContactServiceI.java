package com.edubridge.contactapp.service;

import java.util.List;

import com.edubridge.contactapp.model.Contact;

public interface ContactServiceI {
	void addContact(Contact contact);
	List<Contact> getAllContacts();	
	Contact getContactById(Integer id);
	void updateContact(Contact contact);
	void deleteContact(Integer id);
	void deleteAllContacts();
}
