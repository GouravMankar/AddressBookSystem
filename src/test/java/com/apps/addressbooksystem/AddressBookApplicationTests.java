package com.apps.addressbooksystem;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.apps.addressbooksystem.repository.AddressBookRepository;

@SpringBootTest
class AddressBookApplicationTests {

	@Test
	void contextLoads() {
		
	}
	@Test
    public void shouldRetrieveContactsFromDatabase() {

        AddressBookRepository repo = new AddressBookRepository();

        assertTrue(repo.retrieveContacts() >= 0);
    }

}
