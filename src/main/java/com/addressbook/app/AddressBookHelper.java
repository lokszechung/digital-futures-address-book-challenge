package com.addressbook.app;

public class AddressBookHelper {

    public static void printContact(Contact contact) {

        String name = contact.getName();
        String phone = contact.getPhone();
        String email = contact.getEmail();

        System.out.println(name + ", " + phone + ", " + email);
    }

}
