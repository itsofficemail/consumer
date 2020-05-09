package com.customer.model.converter;

import javax.persistence.AttributeConverter;

import com.customer.util.Crypto;

public class CustomerEncryptionConverter implements AttributeConverter<String, String> {

  @Override
  public String convertToDatabaseColumn(String attribute) {
    if (attribute == null) {
      return null;
    }
    return Crypto.encrypt(attribute);
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    return Crypto.decrypt(dbData);
  }
}
