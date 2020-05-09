package com.customer.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.entity.Customer;
import com.customer.model.AddressDTO;
import com.customer.model.CustomerDTO;
import com.customer.model.CustomerStatusDTO;
import com.customer.model.converter.CustomerEntityConverter;
import com.customer.util.ConverterUtil;
import com.customer.util.JsonUtil;

@RunWith(MockitoJUnitRunner.class)
public class CustomerEntityConverterTest {

  @Spy private CustomerEntityConverter customerEntityConverter;

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

    String payload = JsonUtil.objToString(ConverterUtil.mask(customerDTO));
    Customer customerEntity = customerEntityConverter.convert(customerDTO);

    assertNotNull(customerEntity);
    assertNotNull(customerEntity.getAddress());
    assertNotNull(customerEntity.getAuditLog());

    assertThat(customerDTO.getCustomerNumber(), is(customerEntity.getCustomerNumber()));
    assertThat(customerDTO.getFirstName(), is(customerEntity.getFirstName()));
    assertThat(customerDTO.getLastName(), is(customerEntity.getLastName()));
    assertThat(customerDTO.getBirthDate(), is(customerEntity.getBirthDate()));
    assertThat(customerDTO.getCountry(), is(customerEntity.getCountry()));
    assertThat(customerDTO.getCountryCode(), is(customerEntity.getCountryCode()));
    assertThat(customerDTO.getMobileNumber(), is(customerEntity.getMobileNumber()));
    assertThat(customerDTO.getEmail(), is(customerEntity.getEmail()));

    assertThat(
        customerDTO.getCustomerStatus().toString(),
        is(customerEntity.getCustomerStatus().toString()));

    assertThat(
        customerDTO.getAddress().getAddressLine1(),
        is(customerEntity.getAddress().getAddressLine1()));
    assertThat(
        customerDTO.getAddress().getAddressLine2(),
        is(customerEntity.getAddress().getAddressLine2()));

    assertThat(customerDTO.getAddress().getStreet(), is(customerEntity.getAddress().getStreet()));
    assertThat(
        customerDTO.getAddress().getPostalCode(), is(customerEntity.getAddress().getPostalCode()));

    assertThat(payload, is(customerEntity.getAuditLog().getPayload()));
    assertThat(customerEntity, is(customerEntity.getAuditLog().getCustomer()));
  }
}
