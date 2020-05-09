package com.customer.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.model.converter.CustomerEncryptionConverter;
import com.customer.util.Crypto;

@RunWith(MockitoJUnitRunner.class)
public class CustomerEncryptionConverterTest {

  @Spy private CustomerEncryptionConverter customerEncryptionConverter;

  private String strToEncrypt = null;
  private String encryptedString = null;

  @Before
  public void setupdata() {
    strToEncrypt = "Some string to encrypt";
    encryptedString = Crypto.encrypt(strToEncrypt);
  }

  @Test
  public void convertToDatabaseColumnTest() {
    assertNull(customerEncryptionConverter.convertToDatabaseColumn(null));
    assertEquals(encryptedString, customerEncryptionConverter.convertToDatabaseColumn(strToEncrypt));
  }

  @Test
  public void convertToEntityAttributeTest() {
    assertNull(customerEncryptionConverter.convertToEntityAttribute(null));
    assertEquals(strToEncrypt, customerEncryptionConverter.convertToEntityAttribute(encryptedString));
  }
}
