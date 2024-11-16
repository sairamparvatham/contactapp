package com.edubridge.contactapp.service;

import java.util.List;

import com.edubridge.contactapp.dao.ContactDao;
import com.edubridge.contactapp.model.Contact;

public class ContactService implements ContactServiceI {
	private ContactDao dao;
	
	public ContactService() {
		dao = new ContactDao();
	}
	
	@Override
	public void addContact(Contact contact) {
		dao.addContact(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		return dao.getAllContacts();
	}

	@Override
	public Contact getContactById(Integer id) {
		return dao.getContactById(id);
	}

	@Override
	public void updateContact(Contact contact) {
		dao.updateContact(contact);
	}

	@Override
	public void deleteContact(Integer id) {
		dao.deleteContact(id);
	}

	@Override
	public void deleteAllContacts() {
		dao.deleteAllContacts();
	}
}
