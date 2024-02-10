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
        checkForDuplicate(contact, contacts);
        contacts.add(contact);
    }

    public void displayContact(Contact contact) {
        validateContact(contact);
        AddressBookHelper.printContact(contact);
    }

    public void displayAllContacts() {
        if (contacts.size() == 0) { System.out.println("No contacts in address book"); }
        for (Contact contact: contacts) {
            AddressBookHelper.printContact(contact);
        }
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

    public void removeContact(Contact contactToRemove) {
        validateContact(contactToRemove);
        for (Contact contact: contacts) {
            if (contact.getName().equals(contactToRemove.getName())) {
                contacts.remove(contact);
                return;
            }
        }
    }

    public void editContact(Contact contact, String fieldToEdit, String value) {
        switch (fieldToEdit) {
            case "name":
                contact.setName(value);
                break;
            case "phone":
                contact.setPhone(value);
                break;
            case "email":
                contact.setEmail(value);
                break;
        }
    }

    public void deleteAllContacts() {
        contacts.clear();
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

    private static void checkForDuplicate(Contact contactToValidate, ArrayList<Contact> contacts) {
        for (Contact contact: contacts) {
            if (contact.getPhone().equals(contactToValidate.getPhone())) {
                throw new DuplicatePhoneException("Phone number already exists on another contact, duplicates not allowed");
            }
            if (contact.getEmail().equals(contactToValidate.getEmail())) {
                throw new DuplicateEmailException("Email address already exists on another contact, duplicates not allowed");
            }
        }
    }

}
