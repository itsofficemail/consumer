package com.customer.exception;

public class InvalidDataException extends RuntimeException {

  /** */
  private static final long serialVersionUID = 5371886843589098437L;

  public InvalidDataException() {
    super();
  }

  public InvalidDataException(String message) {
    super(message);
  }

  public InvalidDataException(Throwable throwable) {
    super(throwable);
  }

  public InvalidDataException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
