package com.vigulear.vaadinapp.data.exception_handling.exceptions;

/**
 * @author Constantin Vigulear
 */
public class AlreadyPresentException extends RuntimeException {
  public AlreadyPresentException(String message) {
    super(message);
  }
}
