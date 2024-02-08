package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {

    private String id;
    private ArrayList<Contact> contacts = new ArrayList<>();

    public AddressBook(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public ArrayList<Contact> getContacts() { return contacts; }

    public void addContact(Contact contact) {
            validateContact(contact);
            contacts.add(contact);
    }

    public void displayContact(Contact contact) {
        validateContact(contact);
        AddressBookHelper.printContact(contact);
    }

    private static void validateContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null or empty");
        }
    }


}
