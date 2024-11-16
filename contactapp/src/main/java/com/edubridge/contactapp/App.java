package com.edubridge.contactapp;

import java.util.List;
import java.util.Scanner;

import com.edubridge.contactapp.model.Contact;
import com.edubridge.contactapp.service.ContactService;

public class App {
	public static void main(String[] args) {
		int option = 0;
		Scanner in = new Scanner(System.in);
		ContactService service = new ContactService();
		String name, email, mobile;
		name = email = mobile = null;
		int status = 0;
		do {
			System.out.println("Welcome to Contact Application");
			System.out.println("==============================");
			System.out.println("1. Add Contact");
			System.out.println("2. View All Contacts");
			System.out.println("3. Search Contact");
			System.out.println("4. Update Contact");
			System.out.println("5. Delete Contact");
			System.out.println("6. Delete All Contacts");
			System.out.println("0. Exit");
			System.out.println("Please choose option: ");
			option = in.nextInt();

			switch (option) {
			case 1:
				System.out.println("Add New Contact");
				System.out.println("------------");
				System.out.println("Enter Contact Name: ");
				name = in.next();
				System.out.println("Enter Contact Email: ");
				email = in.next();
				System.out.println("Enter Contact Mobile: ");
				mobile = in.next();

				Contact contact = new Contact();
				contact.setName(name);
				contact.setEmail(email);
				contact.setMobile(mobile);

				service.addContact(contact);
				break;

			case 2:
				System.out.println("View All Contacts");
				System.out.println("-----------------");
				List<Contact> contacts = service.getAllContacts();
				if (contacts.size() != 0) {
					for (Contact c : contacts) {
						System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getEmail() + "\t" + c.getMobile());
					}
				} else {
					System.out.println("no contacts found");
				}
				break;

			case 3:
				System.out.println("Search Contact");
				System.out.println("---------------");
				System.out.println("Please enter contact id: ");
				int id = in.nextInt();
				Contact c = service.getContactById(id);
				if (c != null) {
					System.out.println("Contact Name: " + c.getName());
					System.out.println("Contact Email: " + c.getEmail());
					System.out.println("Contact Mobile: " + c.getMobile());
				} else {
					System.out.println("No contact found with id: " + id);
				}
				break;
				
			case 4:
				System.out.println("Update Contact Details");
				System.out.println("----------------------");
				System.out.println("Enter Contact Id: ");
				int contactId = in.nextInt();
				System.out.println("Enter Contact Name: ");
				name = in.next();
				System.out.println("Enter Contact Email: ");
				email = in.next();
				System.out.println("Enter Contact Mobile: ");
				mobile = in.next();
				
				Contact updatedContact = new Contact();
				updatedContact.setId(contactId);
				updatedContact.setName(name);
				updatedContact.setEmail(email);
				updatedContact.setMobile(mobile);
				service.updateContact(updatedContact);
				break;
				
			case 5:
				System.out.println("Delete Contact");
				System.out.println("--------------");
				System.out.println("Please enter contact id: ");
				int cid = in.nextInt();
				service.deleteContact(cid);				
				break;

			case 6:
				System.out.println("Are sure delete all contacts? [Y/N]");
				String confirm = in.next();
				if(confirm.equalsIgnoreCase("Y")) {
					service.deleteAllContacts();			
				}
				break;
				
			case 0:
				System.out.println("Bye!!!");
				System.exit(0);
				break;
				
			default:
				System.out.println("Please choose correct option: ");
				break;
			}

		} while (option != 0);
	}
}
