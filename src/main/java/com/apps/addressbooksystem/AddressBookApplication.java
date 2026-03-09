package com.apps.addressbooksystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apps.addressbooksystem.service.AddressBook;

@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
		System.out.println("Welcome to Address Book Program");

		AddressBook addressBook = new AddressBook();

		addressBook.addContact();
		addressBook.editContact();
	}
	
}
