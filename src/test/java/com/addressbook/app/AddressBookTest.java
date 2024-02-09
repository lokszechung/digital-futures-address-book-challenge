package com.addressbook.app;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Nested
    @DisplayName("AddressBook Display Contact Tests")

    class AddressBookHelperPrintContactTests {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @Test
        @DisplayName("AddressBook displayContact prints expected values")
        public void testDisplayContact() {

            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact = mock(Contact.class);

            when(testContact.getName()).thenReturn("Lok Sze Chung");
            when(testContact.getPhone()).thenReturn("07123456789");
            when(testContact.getEmail()).thenReturn("loksze@email.com");

            testAddressBook.displayContact(testContact);

            assertEquals("Lok Sze Chung, 07123456789, loksze@email.com", outputStreamCaptor.toString().trim());
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        @DisplayName("AddressBook displayContact throws IllegalArgumentException when null contact is passed in")
        public void testDisplayContactThrowsIllegalArgumentExceptionWhenContactISNull() {

            AddressBook testAddressBook = new AddressBook("ab-1");

            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.displayContact(null);
            });
        }

    }

    @Nested
    @DisplayName("AddressBook searchContact Tests")

    class AddressBookSearchContactTests {

        @Test
        @DisplayName("SearchContact returns contact when a contact with searched name exists")
        public void testAddressBookSearchContactWhenNameExists() throws ContactNotFoundException {
            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact = mock(Contact.class);
            when(testContact.getName()).thenReturn("Lok Sze");

            testAddressBook.addContact(testContact);

            assertEquals(testContact, testAddressBook.searchContact("Lok Sze"));
        }

        @Test
        @DisplayName("SearchContact throws ContactNotFoundException when a contact with searched name does not exist")
        public void testAddressBookSearchContactThrowsContactNotFoundExceptionWhenNameNotExist() {
            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact = mock(Contact.class);
            when(testContact.getName()).thenReturn("Lok Sze");

            testAddressBook.addContact(testContact);

            assertThrows(ContactNotFoundException.class, () -> {
                testAddressBook.searchContact("Macks");
            });
        }

        @Test
        @DisplayName("SearchContact throws IllegalArgumentException when input is null")
        public void testAddressBookSearchContactThrowsIllegalArgumentExceptionWhenNullInput() {
            AddressBook testAddressBook = new AddressBook("ab-1");

            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.searchContact(null);
            });
        }

        @Test
        @DisplayName("SearchContact throws IllegalArgumentException when input is empty")
        public void testAddressBookSearchContactThrowsIllegalArgumentExceptionWhenNullEmpty() {
            AddressBook testAddressBook = new AddressBook("ab-1");

            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.searchContact("");
            });
        }


    }

    @Nested
    @DisplayName("AddressBook removeContact Tests")

    class AddressBookRemoveContactTests {

        @Test
        @DisplayName("RemoveContact removes contact from the AddressBook")
        public void testRemoveContactRemoveContact() {
            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact = mock(Contact.class);
            when(testContact.getName()).thenReturn("Lok Sze");

            testAddressBook.addContact(testContact);
            testAddressBook.removeContact(testContact);

            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        @DisplayName("RemoveContact throws IllegalArgumentException when contact is null")
        public void testRemoveContactThrowsIllegalArgumentExceptionWhenNullContact() {
            AddressBook testAddressBook = new AddressBook("ab-1");

            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.removeContact(null);
            });
        }

    }

    @Nested
    @DisplayName("AddressBook editContact Tests")

    class AddressBookEditContactTests {

        @Test
        @DisplayName("EditContact edit name returns")
        public void testRemoveContactRemoveContact() {
            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact = mock(Contact.class);
            when(testContact.getName()).thenReturn("Lok Sze");

            testAddressBook.addContact(testContact);
            testAddressBook.removeContact(testContact);

            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        @DisplayName("RemoveContact throws IllegalArgumentException when contact is null")
        public void testRemoveContactThrowsIllegalArgumentExceptionWhenNullContact() {
            AddressBook testAddressBook = new AddressBook("ab-1");

            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.removeContact(null);
            });
        }

    }


}
