package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Nested
    @DisplayName("Address Book Constructor Tests")

    class ContactConstructorTests {

        @Test
        @DisplayName("Constructor sets correct values when valid")
        public void testConstructorSetsValuesWhenValid() {
            String testName = "Friend";
            String testPhone = "07777777777";
            String testEmail = "friend@email.com";

            Contact testContact = new Contact(testName, testPhone, testEmail);

            assertAll(
                    () -> assertEquals(testName, testContact.getName()),
                    () -> assertEquals(testPhone, testContact.getPhone()),
                    () -> assertEquals(testEmail, testContact.getEmail())
            );
        }

    }

}
