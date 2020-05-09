package com.customer.exception;

public class GeneralException extends RuntimeException {

  /** */
  private static final long serialVersionUID = 2553219059151219921L;

  public GeneralException() {
    super();
  }

  public GeneralException(String message) {
    super(message);
  }

  public GeneralException(Throwable throwable) {
    super(throwable);
  }

  public GeneralException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
