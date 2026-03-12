package com.apps.addressbooksystem;



import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apps.addressbooksystem.model.Contact;
import com.apps.addressbooksystem.service.AddressBook;
import com.apps.addressbooksystem.service.AddressBookManager;

@SpringBootApplication
public class AddressBookApplication {

    public static void main(String[] args) {

        SpringApplication.run(AddressBookApplication.class, args);

        System.out.println("Welcome to Address Book Program");

        Scanner sc = new Scanner(System.in);
        AddressBookManager manager = new AddressBookManager();

        boolean running = true;

        while (running) {

            System.out.println("1 Create Address Book");
            System.out.println("2 Use Address Book");
            System.out.println("3 Show Address Book");
            System.out.println("4 Search Person by City");
            System.out.println("5 Search Person by State");
            System.out.println("6 Contact count by city");
            System.out.println("7 Contact count by state");
            System.out.println("8 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    manager.createAddressBook();
                    break;

                case 2:

                    AddressBook book = manager.getAddressBook();

                    if (book == null) {
                        break;
                    }

                    boolean usingBook = true;

                    while (usingBook) {

                        System.out.println("1 Add Contact");
                        System.out.println("2 Edit Contact");
                        System.out.println("3 Delete Contact");
                        System.out.println("4 Display Contacts");
                        System.out.println("5 Sort Contacts By Name");
                        System.out.println("6 Sort By City");
                        System.out.println("7 Sort By State");
                        System.out.println("8 Sort By Zip");
                        System.out.println("9 Exit");

                        int option = sc.nextInt();
                        sc.nextLine();

                        switch (option) {

                            case 1:
                                Contact contact = book.addContact();
                                manager.addToCityAndStateMap(contact);
                                break;

                            case 2:
                                book.editContact();
                                manager.rebuildCityAndStateMaps();
                                break;

                            case 3:
                                Contact removed = book.deleteContact();
                                manager.removeFromCityAndStateMap(removed);
                                break;

                            case 4:
                                book.displayContacts();
                                break;

                            case 5:
                                book.sortContactsByName();
                                book.displayContacts();
                                break;

                            case 6:
                                book.sortByCity();
                                book.displayContacts();
                                break;

                            case 7:
                                book.sortByState();
                                book.displayContacts();
                                break;

                            case 8:
                                book.sortByZip();
                                book.displayContacts();
                                break;

                            case 9:
                                usingBook = false;
                                break;

                            default:
                                System.out.println("Invalid option");
                        }
                    }

                    break;

                case 3:
                    manager.displayAddressBooks();
                    break;

                case 4:
                    manager.searchByCity();
                    break;

                case 5:
                    manager.searchByState();
                    break;

                case 6:
                    manager.countByCity();
                    break;

                case 7:
                    manager.countByState();
                    break;

                case 8:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
