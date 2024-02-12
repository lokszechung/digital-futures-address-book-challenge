package com.addressbook.application;

import com.addressbook.app.AddressBook;
import com.addressbook.app.Contact;
import com.addressbook.app.ContactNotFoundException;

import java.util.Scanner;

public class App {

    public static Scanner scanner = new Scanner(System.in);
    public static AddressBook addressBook = new AddressBook("ab-1");
    public static Contact currentContact;

    public static void main(String[] args) {

        System.out.println("Welcome to your address book");

        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("What would you like to do:\n1. Search for a contact\n2. See all contacts\n3. Add a new contact\n4. Delete all contacts\n5. Exit address book");

        String mainOption = scanner.nextLine();
        processMainMenuInput(mainOption);
    }

    public static void processMainMenuInput(String input) {
        switch (input) {
            case "1":
                System.out.println("\nSearch for a contact\n");
                searchContact();
                break;
            case "2":
                System.out.println("\nSee all contacts\n");
                displayAllContacts();
                break;
            case "3":
                System.out.println("\nAdd a contact\n");
                addContact();
                break;
            case "4":
                System.out.println("\nDelete all contacts\n");
                deleteAllContacts();
                break;
            case "5":
                System.out.println("Closing address book. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid input. Please choose 1, 2, 3, 4 or 5");
                mainMenu();
        }
    }

    public static void contactMenu() {
        System.out.println("What would you like to do with this contact:\n1. Edit contact\n2. Remove contact\n3. Back to main menu");

        String contactOption = scanner.nextLine();
        processContactMenuInput(contactOption);
    }

    public static void processContactMenuInput(String input) {
        switch (input) {
            case "1":
                System.out.println("Edit contact");
                editContact();
                break;
            case "2":
                System.out.println("Remove contact");
                removeContact();
                break;
            case "3":
                System.out.println("Back to main menu\n");
                mainMenu();
                break;
            default:
                System.out.println("Invalid input. Please choose 1, 2 or 3");
                contactMenu();
        }
    }

    public static void processContinueAddInput(String input) {
        if (input.equalsIgnoreCase("y")) {
            addContact();
        }
        if (!input.equalsIgnoreCase("y")) {
            mainMenu();
        }
    }

    public static void processContinueSearch(String input) {
        if (input.equalsIgnoreCase("y")) {
            searchContact();
        }
        if (!input.equalsIgnoreCase("y")) {
            mainMenu();
        }
    }

    public static void addContact() {
        System.out.println("Enter contact name:");
        String name = scanner.nextLine();

        System.out.println("Enter contact phone number:");
        String phone = scanner.nextLine();

        System.out.println("Enter contact email address:");
        String email = scanner.nextLine();


        try {
            Contact contact = new Contact(name, phone, email);
            addressBook.addContact(contact);
            System.out.println("SUCCESS: Contact successfully added\n");
            currentContact = contact;
            addressBook.displayContact(contact);
            contactMenu();
        }
        catch (Exception e) {
            System.out.println("WARNING: Contact not added. " + e.getMessage());
            System.out.println("Continue adding contact? (y/n)");
            String continueAdd = scanner.nextLine();
            processContinueAddInput(continueAdd);

        }
    }

    public static void searchContact() {
        System.out.println("Search for contact by name:");
        String searchedName = scanner.nextLine();

        try {
           Contact result = addressBook.searchContact(searchedName);
           System.out.println("\nCONTACT FOUND:");
           currentContact = result;
           addressBook.displayContact(result);
           System.out.println("");
           contactMenu();
        }
        catch (ContactNotFoundException e) {
            System.out.println("NOT FOUND: " + e.getMessage());
            System.out.println("Continue searching for a contact? (y/n)");
            String continueSearch = scanner.nextLine();
            processContinueSearch(continueSearch);
        }
        catch (Exception e) {
            System.out.println("WARNING: " + e.getMessage());
            searchContact();
        }
    }

    public static void displayAllContacts() {
        addressBook.displayAllContacts();
        System.out.println("");
        mainMenu();
    }

    public static void editContact() {
        System.out.println("");
        System.out.println("What would you like to edit:\n1. Name\n2. Phone number\n3. Email address\n4. Exit contact editing");

        String fieldToEdit = scanner.nextLine();
        switch (fieldToEdit) {
            case "1":
                editField("name");
                break;
            case "2":
                editField("phone");
                break;
            case "3":
                editField("email");
                break;
            case "4":
                contactMenu();
                break;
            default:
                System.out.println("Invalid input. Please choose 1, 2, 3 or 4");
                editContact();

        }
    }

    public static void removeContact() {
        try {
            addressBook.removeContact(currentContact);
            System.out.println("SUCCESS: Contact successfully removed\n");
            mainMenu();
        }
        catch (Exception e) {
            System.out.println("WARNING: Contact not removed. " + e.getMessage());
            contactMenu();
        }
    }

    public static boolean confirmDeleteAll() {
        System.out.println("Are you sure you want to delete all contacts? (y/n)");
        String confirmation = scanner.nextLine();
        return confirmation.equalsIgnoreCase("y") ? true : false;

    }

    public static void deleteAllContacts() {
//        boolean confirmed = confirmDeleteAll();
        if (confirmDeleteAll()) {
            try {
                addressBook.deleteAllContacts();
                System.out.println("SUCCESS: All contacts deleted\n");
                mainMenu();
            }
            catch (Exception e) {
                System.out.println("WARNING: Not Deleted. " + e.getMessage());
                mainMenu();
            }
        }
        mainMenu();
    }



    public static void editField(String field) {
        System.out.println("Enter new " + field + ":");
        String newValue = scanner.nextLine();

        try {
            addressBook.editContact(currentContact, field, newValue);
            System.out.println("SUCCESS: Contact successfully edited\n");
            addressBook.displayContact(currentContact);
            contactMenu();
        }
        catch (Exception e) {
            System.out.println("WARNING: Contact not edited. " + e.getMessage());
            System.out.println("Continue editing contact? (y/n)");
            String continueEdit = scanner.nextLine();
            processContinueEditInput(continueEdit, field);
        }
    }

    public static void processContinueEditInput(String input, String field) {
        if (input.equalsIgnoreCase("y")) {
            editField(field);
        }
        if (!input.equalsIgnoreCase("y")) {
            contactMenu();
        }
    }

}
