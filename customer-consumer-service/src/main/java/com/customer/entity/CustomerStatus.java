package com.customer.entity;

public enum CustomerStatus {
  OPEN("O"),
  CLOSE("C"),
  SUSPENDED("S"),
  RESTORED("R");

  private String value;

  CustomerStatus(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }

  public static CustomerStatus fromValue(String text) {
    for (CustomerStatus b : CustomerStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
