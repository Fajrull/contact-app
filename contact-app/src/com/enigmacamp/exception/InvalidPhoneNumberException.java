package com.enigmacamp.exception;

public class InvalidPhoneNumberException extends RuntimeException {
  public InvalidPhoneNumberException(String message) {
    super(message);
  }
}
