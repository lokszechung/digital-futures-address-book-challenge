package com.addressbook.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AddressBookHelperTest {

    @Nested
    @DisplayName("AddressBookHelper Print Contact Tests")

    class AddressBookHelperPrintContactTests {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @Test
        @DisplayName("AddressBookHelper PrintContact prints expected values")
        public void testPrintContact() {

            Contact testContact = mock(Contact.class);

            when(testContact.getName()).thenReturn("Lok Sze Chung");
            when(testContact.getPhone()).thenReturn("07123456789");
            when(testContact.getEmail()).thenReturn("loksze@email.com");

            AddressBookHelper.printContact(testContact);

            assertEquals("Lok Sze Chung, 07123456789, loksze@email.com", outputStreamCaptor.toString().trim());
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

    }

}
