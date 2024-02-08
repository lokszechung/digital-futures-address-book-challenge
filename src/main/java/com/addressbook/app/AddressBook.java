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

    public Contact searchContact(String name) throws ContactNotFoundException {
        validateSearchInput(name);
        for (Contact contact: contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        throw new ContactNotFoundException(name + " does not exists in your contacts");
    }

    private static void validateContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null or empty");
        }
    }

    private static void validateSearchInput(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Search input cannot be null or empty");
        }
    }




}
