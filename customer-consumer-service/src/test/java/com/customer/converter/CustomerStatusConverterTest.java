package com.customer.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.entity.CustomerStatus;
import com.customer.model.converter.CustomerStatusConverter;

@RunWith(MockitoJUnitRunner.class)
public class CustomerStatusConverterTest {

  @Spy CustomerStatusConverter customerStatusConverter;

  @Test
  public void convertToDatabaseColumnTest() {
    assertNull(customerStatusConverter.convertToDatabaseColumn(null));
    assertEquals(
        CustomerStatus.OPEN.toString(),
        customerStatusConverter.convertToDatabaseColumn(CustomerStatus.OPEN));
  }

  @Test
  public void convertToEntityAttributeTest() {
    assertNull(customerStatusConverter.convertToEntityAttribute(null));
    assertEquals(
        CustomerStatus.OPEN,
        customerStatusConverter.convertToEntityAttribute(CustomerStatus.OPEN.toString()));
  }
}
