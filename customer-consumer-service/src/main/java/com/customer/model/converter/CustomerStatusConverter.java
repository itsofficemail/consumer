package com.customer.model.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;

import com.customer.entity.CustomerStatus;

public class CustomerStatusConverter implements AttributeConverter<CustomerStatus, String> {

  @Override
  public String convertToDatabaseColumn(CustomerStatus status) {
    if (status == null) {
      return null;
    }
    return status.toString();
  }

  @Override
  public CustomerStatus convertToEntityAttribute(String dbStatusValue) {
    if (dbStatusValue == null) {
      return null;
    }

    return Stream.of(CustomerStatus.values())
        .filter(c -> c.toString().equals(dbStatusValue))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
