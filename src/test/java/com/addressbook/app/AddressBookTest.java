package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {

    @DisplayName("Address Book Constructor Tests")

        @Test
        public void testAddressBookGetId() {
            AddressBook addressBook = new AddressBook("ab-1");

            assertEquals("ab-1", addressBook.getId());
        }



}
