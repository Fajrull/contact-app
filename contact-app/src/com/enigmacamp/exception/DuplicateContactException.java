package com.enigmacamp.exception;

public class DuplicateContactException extends RuntimeException {
  public DuplicateContactException(String message) {
    super(message);
  }
}
