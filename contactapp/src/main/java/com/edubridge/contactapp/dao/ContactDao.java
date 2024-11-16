package com.edubridge.contactapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.contactapp.model.Contact;
import com.edubridge.contactapp.utils.HibernateUtils;

public class ContactDao implements ContactDaoI {

	@Override
	public void addContact(Contact contact) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.persist(contact);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("new contact addedd!");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			String hql = "from Contact";
			Query query = session.createQuery(hql, Contact.class);
			contacts = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public Contact getContactById(Integer id) {
		Contact contact = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			contact = session.get(Contact.class, id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return contact;
	}

	@Override
	public void updateContact(Contact contact) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.merge(contact);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("contact is updated!");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteContact(Integer id) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Contact contact = session.get(Contact.class, id);

			if (contact != null) {
				session.remove(contact);
				tx.commit();
				System.out.println("Contact is deleted!");
			} else {
				System.out.println("no contact found!");
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAllContacts() {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			String hql = "delete from Contact";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("All contacts are deleted");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
