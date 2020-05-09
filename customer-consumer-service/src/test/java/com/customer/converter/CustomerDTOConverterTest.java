package com.customer.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.constants.AppConstants;
import com.customer.model.AddressDTO;
import com.customer.model.CustomerDTO;
import com.customer.model.CustomerStatusDTO;
import com.customer.model.converter.CustomerDTOConverter;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDTOConverterTest {

  @Spy private CustomerDTOConverter customerDTOConverter;

  private CustomerDTO customerDTO = null;

  @Before
  public void setupData() {

    AddressDTO addressDTO = new AddressDTO();
    addressDTO.setAddressLine1("Hyderabad");
    addressDTO.setAddressLine2("Telangana");
    addressDTO.setStreet("Street");
    addressDTO.setPostalCode("50937");

    customerDTO = new CustomerDTO();
    customerDTO.setCustomerNumber("C000000001");
    customerDTO.setFirstName("MaheshReddy");
    customerDTO.setLastName("SuramSuram");
    customerDTO.setBirthDate("2000-01-01");
    customerDTO.setCountry("India");
    customerDTO.setCountryCode("IN");
    customerDTO.setMobileNumber("9999999999");
    customerDTO.setEmail("mahesh@suram.com");
    customerDTO.setCustomerStatus(CustomerStatusDTO.OPEN);
    customerDTO.setAddress(addressDTO);
  }

  @Test
  public void testConvertion() {

    CustomerDTO customerMaskedDTO = customerDTOConverter.convert(customerDTO);

    assertNotEquals(customerDTO, customerMaskedDTO);
    assertEquals(customerDTO.getCustomerStatus(), customerMaskedDTO.getCustomerStatus());
    assertEquals(customerDTO.getAddress(), customerMaskedDTO.getAddress());

    assertThat(
        customerDTO.getCustomerNumber().replaceAll(AppConstants.EXCEPT_LAST_4, "*"),
        is(customerMaskedDTO.getCustomerNumber()));

    assertThat(
        customerDTO.getBirthDate().replaceAll(AppConstants.EXCEPT_LAST_4, "*"),
        is(customerMaskedDTO.getBirthDate()));

    assertThat(
        customerDTO.getMobileNumber().replaceAll(AppConstants.EXCEPT_LAST_4, "*"),
        is(customerMaskedDTO.getMobileNumber()));

    assertThat(
        customerDTO.getEmail().replaceAll(AppConstants.EMAIL_MASK_REGEX, "*"),
        is(customerMaskedDTO.getEmail()));

    assertThat(customerDTO.getFirstName(), is(customerMaskedDTO.getFirstName()));
    assertThat(customerDTO.getLastName(), is(customerMaskedDTO.getLastName()));
    assertThat(customerDTO.getCountry(), is(customerMaskedDTO.getCountry()));
    assertThat(customerDTO.getCountryCode(), is(customerMaskedDTO.getCountryCode()));
  }
}
