package com.vigulear.vaadinapp.data.aspect.exception_handling.exceptions;

/**
 * @author Constantin Vigulear
 */
public class AlreadyPresentException extends RuntimeException {
  public AlreadyPresentException(String message) {
    super(message);
  }
}
