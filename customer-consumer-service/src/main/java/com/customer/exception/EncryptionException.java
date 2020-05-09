package com.customer.exception;

public class EncryptionException extends RuntimeException {

  /** */
  private static final long serialVersionUID = 150485286667892327L;

  public EncryptionException() {
    super();
  }

  public EncryptionException(String message) {
    super(message);
  }

  public EncryptionException(Throwable throwable) {
    super(throwable);
  }

  public EncryptionException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
