package com.addressbook.app;

public class Contact {

    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        validateName(name);
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() { return name; }

    public String getPhone() { return phone; }

    public String getEmail() { return email; }

    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact name cannot be null or empty");
        }
        if(!name.trim().matches("^[a-zA-Z]+(?:[\\s\\-][a-zA-Z]+)*$")) {
            throw new IllegalArgumentException("Contact name must only contain letters, hyphens, apostrophes and spaces");
        }
    }

}
