package com.addressbook.app;

import org.junit.jupiter.api.*;

import javax.sound.midi.SysexMessage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

        @Test
        @DisplayName("AddContact throws DuplicatePhoneException when phone already exists")
        public void testAddressBookThrowsDuplicatePhoneExceptionWhenDuplicatePhone() {
            AddressBook testAddressBook = new AddressBook("ab-1");

            Contact testContact1 = mock(Contact.class);
            when(testContact1.getPhone()).thenReturn("07123456789");

            testAddressBook.addContact(testContact1);

            Contact testContact2 = mock(Contact.class);
            when(testContact2.getPhone()).thenReturn("07123456789");

            assertThrows(DuplicatePhoneException.class, () -> {
                testAddressBook.addContact(testContact2);
            });
        }

        @Test
        @DisplayName("AddContact throws DuplicateEmailException when email already exists")
        public void testAddressBookThrowsDuplicateEmailExceptionWhenDuplicateEmail() {
            AddressBook testAddressBook = new AddressBook("ab-1");

            Contact testContact1 = mock(Contact.class);
            when(testContact1.getPhone()).thenReturn("07123456789");
            when(testContact1.getEmail()).thenReturn("same@email.com");

            testAddressBook.addContact(testContact1);

            Contact testContact2 = mock(Contact.class);
            when(testContact2.getPhone()).thenReturn("07987654321");
            when(testContact2.getEmail()).thenReturn("same@email.com");

            assertThrows(DuplicateEmailException.class, () -> {
                testAddressBook.addContact(testContact2);
            });
        }

    }

    @Nested
    @DisplayName("AddressBook Display Contact Tests")

    class AddressBookPrintContactTests {

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
        @DisplayName("EditContact edit name calls Contact.setName")
        public void testEditContactNameCallsSetName() {
            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact = mock(Contact.class);

            testAddressBook.addContact(testContact);
            String newName = "Bobby Bagelz";
            testAddressBook.editContact(testContact, "name", newName);

            verify(testContact).setName(newName);
        }

        @Test
        @DisplayName("EditContact edit phone calls Contact.setPhone")
        public void testEditContactPhoneCallsSetPhone() {
            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact = mock(Contact.class);

            testAddressBook.addContact(testContact);
            String newPhone = "07123123123";
            testAddressBook.editContact(testContact, "phone", newPhone);

            verify(testContact).setPhone(newPhone);
        }

        @Test
        @DisplayName("EditContact edit email calls Contact.setEmail")
        public void testEditContactEmailCallsSetEmail() {
            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact = mock(Contact.class);

            testAddressBook.addContact(testContact);
            String newEmail = "new@email.com";
            testAddressBook.editContact(testContact, "email", newEmail);

            verify(testContact).setEmail(newEmail);
        }

    }

    @Nested
    @DisplayName("AddressBook Display All Contact Tests")

    class AddressBookDisplayAllContactTests {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @Test
        @DisplayName("AddressBook displayAllContact prints expected values")
        public void testDisplayAllContact() {

            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact1 = mock(Contact.class);

            when(testContact1.getName()).thenReturn("Lok Sze Chung");
            when(testContact1.getPhone()).thenReturn("07123456789");
            when(testContact1.getEmail()).thenReturn("loksze@email.com");

            Contact testContact2 = mock(Contact.class);

            when(testContact2.getName()).thenReturn("Not Sze Chung");
            when(testContact2.getPhone()).thenReturn("07987654321");
            when(testContact2.getEmail()).thenReturn("notsze@email.com");

            testAddressBook.addContact(testContact1);
            testAddressBook.addContact(testContact2);

            testAddressBook.displayAllContacts();

            String expectedOutput = "Lok Sze Chung, 07123456789, loksze@email.com\nNot Sze Chung, 07987654321, notsze@email.com";

            assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        }

        @Test
        @DisplayName("AddressBook displayAllContact prints message when no contacts")
        public void testDisplayAllContactWithNoContacts() {

            AddressBook testAddressBook = new AddressBook("ab-1");

            testAddressBook.displayAllContacts();

            assertEquals("No contacts in address book", outputStreamCaptor.toString().trim());
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }


    }

    @Nested
    @DisplayName("Delete All Contacts Tests")

    class AddressBookDeleteAllContactTests {

        @Test
        @DisplayName("DeleteAllContacts deletes all contacts from addressBook")
        public void testAddressBookDeleteAllContactDeletesAll() {
            AddressBook testAddressBook = new AddressBook("ab-1");
            Contact testContact1 = mock(Contact.class);

            when(testContact1.getPhone()).thenReturn("07987654321");
            when(testContact1.getEmail()).thenReturn("test1@email.com");

            Contact testContact2 = mock(Contact.class);

            when(testContact2.getPhone()).thenReturn("07987654324");
            when(testContact2.getEmail()).thenReturn("test2@email.com");

            testAddressBook.addContact(testContact1);
            testAddressBook.addContact(testContact2);

            assertEquals(2, testAddressBook.getContacts().size());

            testAddressBook.deleteAllContacts();

            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        @DisplayName("DeleteAllContacts works when contacts array is empty")
        public void testAddressBookDeleteAllContactNoErrorWhenEmpty() {
            AddressBook testAddressBook = new AddressBook("ab-1");

            assertEquals(0, testAddressBook.getContacts().size());

            testAddressBook.deleteAllContacts();

            assertEquals(0, testAddressBook.getContacts().size());
        }

    }



}
