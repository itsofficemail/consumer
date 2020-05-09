package com.customer.util;

import com.customer.entity.Customer;
import com.customer.model.CustomerDTO;
import com.customer.model.converter.CustomerDTOConverter;
import com.customer.model.converter.CustomerEntityConverter;

public class ConverterUtil {

  private static final CustomerDTOConverter CUSTOMER_RAW_DATA_CONVERTER =
      new CustomerDTOConverter();

  private static final CustomerEntityConverter CUSTOMER_ENTITY_CONVERTER =
      new CustomerEntityConverter();

  private ConverterUtil() {}

  public static CustomerDTO mask(CustomerDTO dto) {
    return CUSTOMER_RAW_DATA_CONVERTER.convert(dto);
  }

  public static Customer toEntity(CustomerDTO dto) {
    return CUSTOMER_ENTITY_CONVERTER.convert(dto);
  }
}
