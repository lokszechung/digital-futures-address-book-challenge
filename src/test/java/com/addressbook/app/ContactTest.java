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
        public void testContactConstructorSetsValuesWhenValid() {
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

        @Nested
        @DisplayName("Constructor name tests")

        class ConstructorContactNameTests {

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when name is null")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenNameIsNull() {

                String testName = null;
                String testPhone = "07123456789";
                String testEmail = "null@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when name is null")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenNameIsEmpty() {

                String testName = "";
                String testPhone = "07123456789";
                String testEmail = "null@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when name is whitespace")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenNameIsWhitespace() {

                String testName = "  ";
                String testPhone = "07123456789";
                String testEmail = "null@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when name does not meet pattern")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenNameDoesNotMeetPattern() {

                String testName = "N4m3 w1th numb3r5";
                String testPhone = "07123456789";
                String testEmail = "null@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

        }

    }

}
