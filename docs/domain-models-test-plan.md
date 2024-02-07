# Domain Models, Class Diagrams and Test Plan

## Requirements

The user should be able to add a contact to the address book
A contact should have at least a name, phone number and email address
The user should be able to search for a contact by name and have the results displayed
The user should be able to remove a contact from the address book
The user should be able to edit a contact's details
Duplicate phone numbers or email addresses should not be allowed, i.e. no two contacts should have the same phone number or email address
The user should be able to view all contacts in the address book
The user should be using a console interface to interact with the application

## User Stories

1. As a user, I want to access my address book, so I can add and view contacts.
2. As a user, I want to be able to create a contact with a name, phone and email, so I can add it to the address book.
3. As a user, I want to be able to add a contact to my address book, so I can keep their details. 
3. As a user, I want to be able to have a contact displayed, so I can view their details. 
4. As a user, I want to be able to search for a contact by name, so I can find a particular contact. 
5. As a user, I want to be able to search for a contact by name and have the results displayed, so I can view a contact.
6. As a user, I want to be able to remove a contact, so I can...
7. As a user, I want to be able to edit a contact's details, so I can update any changes. 
8. As an address book, I do not want to allow duplicate phone numbers or emails, so that errors do not occur.
9. As a user, I want to be able to view all contacts in the address book
10. As a user, I want to be able to interact with my address book using a console interface. 

## Class Diagrams

```mermaid
classDiagram
    class AddressBook {
        -addressBookId String
        -contacts ArrayList<Contact>
        +addContact(Contact contact): void
    }
    class Contact {
        -name String
        -phone String
        -email String
    }
```

