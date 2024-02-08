package com.addressbook.app;

public class ContactNotFoundException extends Exception{

    public ContactNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
