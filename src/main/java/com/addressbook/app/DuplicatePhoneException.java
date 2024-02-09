package com.addressbook.app;

public class DuplicatePhoneException extends IllegalArgumentException {

    public DuplicatePhoneException(String errorMessage) {
        super(errorMessage);
    }

}
