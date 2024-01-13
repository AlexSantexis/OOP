package Exceptions;

import DesignPatterns.ch1.Model.MobileContact;

public class ContactNotFoundException extends Exception {
    private final static long serialVersionUID = 1L;

    public ContactNotFoundException(String phoneNumber) {
        super("The mobile contact with phone number " + phoneNumber + " was not found");
    }

    public ContactNotFoundException(Long id) {
        super("The mobile contact with id " + id + " was not found");
    }

    public ContactNotFoundException(MobileContact mobileContact) {
        super("The mobile contact with id " + mobileContact.getId() + " and phone number " + mobileContact.getPhoneNumber() + " was not found");
    }

}
