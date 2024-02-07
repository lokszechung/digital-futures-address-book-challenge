package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}
