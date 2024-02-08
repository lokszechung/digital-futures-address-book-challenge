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
            @DisplayName("Constructor throws IllegalArgumentException when name is empty")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenNameIsEmpty() {

                String testName = "";
                String testPhone = "07123456789";
                String testEmail = "empty@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when name is whitespace")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenNameIsWhitespace() {

                String testName = "  ";
                String testPhone = "07123456789";
                String testEmail = "space@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when name does not meet pattern")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenNameDoesNotMeetPattern() {

                String testName = "N4m3 w1th numb3r5";
                String testPhone = "07123456789";
                String testEmail = "number@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

        }

        @Nested
        @DisplayName("Constructor phone tests")

        class ConstructorContactPhoneTests {

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when phone is null")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenPhoneIsNull() {

                String testName = "Lok Sze Chung";
                String testPhone = null;
                String testEmail = "null@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when phone is empty")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenPhoneIsEmpty() {

                String testName = "Lok Sze Chung";
                String testPhone = "";
                String testEmail = "empty@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when phone is whitespace")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenPhoneIsWhitespace() {

                String testName = "Lok Sze Chung";
                String testPhone = " ";
                String testEmail = "space@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when phone does not meet pattern")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenPhoneDoesNotMeetPattern() {

                String testName = "Lok Sze Chung";
                String testPhone = "12334";
                String testEmail = "number@email.com";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

        }

        @Nested
        @DisplayName("Constructor email tests")

        class ConstructorContactEmailTests {

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when email is null")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenEmailIsNull() {

                String testName = "Lok Sze Chung";
                String testPhone = "07123456789";
                String testEmail = null;

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when email is empty")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenEmailIsEmpty() {

                String testName = "Lok Sze Chung";
                String testPhone = "07123456789";
                String testEmail = "";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when email is whitespace")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenEmailIsWhitespace() {

                String testName = "Lok Sze Chung";
                String testPhone = "07123456789";
                String testEmail = "  ";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws IllegalArgumentException when email does not meet pattern")
            public void testContactConstructorThrowsIllegalArgumentExceptionWhenEmailDoesNotMeetPattern() {

                String testName = "Lok Sze Chung";
                String testPhone = "07123456789";
                String testEmail = "invalid.email";

                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testName, testPhone, testEmail);
                });
            }

        }

    }

}
