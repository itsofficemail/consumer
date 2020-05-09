package com.customer.model.converter;

import com.customer.constants.AppConstants;
import com.customer.model.CustomerDTO;

public class CustomerDTOConverter implements Converter<CustomerDTO, CustomerDTO> {

  private static final String REPLACE_WITH = "*";

  @Override
  public CustomerDTO convert(CustomerDTO cust) {

    CustomerDTO customer = new CustomerDTO();

    customer.setCustomerNumber(
        cust.getCustomerNumber().replaceAll(AppConstants.EXCEPT_LAST_4, REPLACE_WITH));
    customer.setFirstName(cust.getFirstName());
    customer.setLastName(cust.getLastName());
    customer.setBirthDate(cust.getBirthDate().replaceAll(AppConstants.EXCEPT_LAST_4, REPLACE_WITH));
    customer.setCountry(cust.getCountry());
    customer.setCountryCode(cust.getCountryCode());
    customer.setMobileNumber(
        cust.getMobileNumber().replaceAll(AppConstants.EXCEPT_LAST_4, REPLACE_WITH));
    customer.setEmail(cust.getEmail().replaceAll(AppConstants.EMAIL_MASK_REGEX, REPLACE_WITH));
    customer.setCustomerStatus(cust.getCustomerStatus());
    customer.setAddress(cust.getAddress());

    return customer;
  }
}
