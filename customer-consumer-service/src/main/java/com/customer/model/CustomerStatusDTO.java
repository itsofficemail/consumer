package com.customer.model;

public enum CustomerStatusDTO {
  OPEN("O"),
  CLOSE("C"),
  SUSPENDED("S"),
  RESTORED("R");

  private String value;

  CustomerStatusDTO(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
