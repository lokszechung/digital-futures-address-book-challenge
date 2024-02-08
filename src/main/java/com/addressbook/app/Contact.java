package com.addressbook.app;

public class Contact {

    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        validateName(name);
        validatePhone(phone);
        validateEmail(email);
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

    private static void validatePhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact phone cannot be null or empty");
        }
        if(!phone.trim().matches("^0\\d{10}$")) {
            throw new IllegalArgumentException("Contact phone must be a valid phone number");
        }
    }

    private static void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact email cannot be null or empty");
        }
        if(!email.trim().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Contact email must be a valid email address");
        }

    }

}
