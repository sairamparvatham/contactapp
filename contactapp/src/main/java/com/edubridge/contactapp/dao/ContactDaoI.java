package com.edubridge.contactapp.dao;

import java.util.List;

import com.edubridge.contactapp.model.Contact;

public interface ContactDaoI {
	void addContact(Contact contact);
	List<Contact> getAllContacts();	
	Contact getContactById(Integer id);
	void updateContact(Contact contact);
	void deleteContact(Integer id);
	void deleteAllContacts();
}
