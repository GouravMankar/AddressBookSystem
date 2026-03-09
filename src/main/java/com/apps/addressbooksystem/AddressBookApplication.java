package com.apps.addressbooksystem;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apps.addressbooksystem.service.AddressBook;

@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
		System.out.println("Welcome to Address Book Program");

		AddressBook addressBook = new AddressBook();
		Scanner sc=new Scanner(System.in);

		boolean running = true;

		while (running) {

		    System.out.println("1 Add Contact");
		    System.out.println("2 Edit Contact");
		    System.out.println("3 Delete Contact");
		    System.out.println("4 Display Contacts");
		    System.out.println("5 Exit");

		    System.out.print("Enter your choice: ");
		    int choice = sc.nextInt();
		    sc.nextLine();

		    switch (choice) {

		        case 1:
		            addressBook.addContact();
		            break;

		        case 2:
		            addressBook.editContact();
		            break;

		        case 3:
		            addressBook.deleteContact();
		            break;

		        case 4:
		            addressBook.displayContacts();
		            break;

		        case 5:
		            running = false;   // stop loop
		            break;

		        default:
		            System.out.println("Invalid choice.");
		    }
		}
		sc.close();
	}
	
}
