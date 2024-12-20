package com.enigmacamp;

import com.enigmacamp.exception.ContactNotFoundException;
import com.enigmacamp.exception.InvalidEmailException;
import com.enigmacamp.exception.InvalidPhoneNumberException;

public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        validateName(name);
        validatePhoneNumber(phoneNumber);
        validateEmail(email);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void validateName(String name) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
        }

    public void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("[0-9]+")) {
            throw new InvalidPhoneNumberException("Phone number must be numeric");
        }
        if (phoneNumber.length() < 10) {
            throw new InvalidPhoneNumberException("Phone number must be at least 10 digits");
        }
    }

    public void validateEmail(String email) { {
        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidEmailException("Email must be valid");
        }
    }
}
}