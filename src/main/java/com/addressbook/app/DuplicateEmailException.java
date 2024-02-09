package com.addressbook.app;

public class DuplicateEmailException extends IllegalArgumentException {

    public DuplicateEmailException(String errorMessage) {
        super(errorMessage);
    }


}
