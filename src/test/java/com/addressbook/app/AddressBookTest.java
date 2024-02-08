package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class AddressBookTest {

    @Nested
    @DisplayName("Address Book Constructor Tests")

    class AddressBookConstructorTests {

        @Test
        @DisplayName("Constructor sets correct ID when valid")
        public void testAddressBookGetId() {
            AddressBook testAddressBook = new AddressBook("ab-1");

            assertEquals("ab-1", testAddressBook.getId());
        }

    }

    @Nested
    @DisplayName("Address Book addContact Tests")

    class AddressBookAddContactTests {

        @Test
        @DisplayName("AddContact adds a contact when valid contact is passed in")
        public void testAddressBookAddContactWithValidContact() {
            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact = mock(Contact.class);

            testAddressBook.addContact(testContact);

            assertEquals(1, testAddressBook.getContacts().size());
        }

        @Test
        @DisplayName("AddContact throws IllegalArgumentException when null contact is passed in")
        public void testAddressBookThrowsIllegalArgumentExceptionWithNullContact() {
            AddressBook testAddressBook = new AddressBook("ab-1");

            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.addContact(null);
            });
        }

    }

}
