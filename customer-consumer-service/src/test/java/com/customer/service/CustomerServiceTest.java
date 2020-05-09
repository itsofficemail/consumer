package com.customer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.entity.Address;
import com.customer.entity.Customer;
import com.customer.entity.CustomerStatus;
import com.customer.respository.CustomerRepository;
import com.customer.service.impl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

  @Mock private CustomerRepository userRepository;

  @InjectMocks private CustomerServiceImpl customerService;

  private Customer customer = null;

  @Before
  public void setupData() {

    customer = new Customer();

    customer.setId(1);
    customer.setCustomerNumber("C000000001");
    customer.setFirstName("MaheshReddy");
    customer.setLastName("SuramSuram");
    customer.setBirthDate("01-01-2000");
    customer.setCountry("India");
    customer.setCountryCode("IN");
    customer.setMobileNumber("9999999999");
    customer.setEmail("mahesh@suram.com");

    customer.setCustomerStatus(CustomerStatus.OPEN);

    Address address = new Address();
    customer.setId(2);
    address.setAddressLine1("Hyderabad, Telangana");
    address.setAddressLine2("Kaalimandir");
    address.setStreet("Bandlaguda");
    address.setPostalCode("50937");
    address.setDateCreated(new Date());
    address.setDateUpdated(new Date());

    customer.setAddress(address);
    customer.setDateCreated(new Date());
    customer.setDateUpdated(new Date());
  }

  @Test
  public void saveUser() {

    when(userRepository.save(customer)).thenReturn(customer);

    Customer actualCustomer = customerService.save(customer);

    assertNotNull(actualCustomer);
    assertEquals(customer, actualCustomer);
  }
}
