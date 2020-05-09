package com.customer.consumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.entity.Customer;
import com.customer.entity.ErrorLog;
import com.customer.kafka.KafkaConsumerListener;
import com.customer.model.AddressDTO;
import com.customer.model.CustomerDTO;
import com.customer.model.CustomerStatusDTO;
import com.customer.service.CustomerService;
import com.customer.service.ErrorLogService;

@RunWith(MockitoJUnitRunner.class)
public class KafkaConsumerListenerTest {

  @Mock private CustomerService customerService;
  @Mock private ErrorLogService errorLogService;

  @InjectMocks private KafkaConsumerListener kafkaConsumerListener;

  private CustomerDTO customerDTO = null;

  @Before
  public void setupData() {

    customerDTO = new CustomerDTO();

    customerDTO.setCustomerNumber("C000000001");
    customerDTO.setFirstName("MaheshReddy");
    customerDTO.setLastName("SuramSuram");
    customerDTO.setBirthDate("01-01-2000");
    customerDTO.setCountry("India");
    customerDTO.setCountryCode("IN");
    customerDTO.setMobileNumber("9999999999");
    customerDTO.setEmail("mahesh@suram.com");

    customerDTO.setCustomerStatus(CustomerStatusDTO.OPEN);

    AddressDTO address = new AddressDTO();
    address.setAddressLine1("Hyderabad, Telangana");
    address.setPostalCode("50937");

    customerDTO.setAddress(address);
  }

  @Test
  public void consumeUserPositive() {
    kafkaConsumerListener.consumeUser(customerDTO);

    verify(customerService, times(1)).save(any(Customer.class));
  }

  @Test(expected = Exception.class)
  public void consumeUserNegetive() {

    when(customerService.save(null)).thenThrow(Exception.class);

    kafkaConsumerListener.consumeUser(null);

    verify(customerService, times(1)).save(any(Customer.class));
    verify(errorLogService, times(1)).save(any(ErrorLog.class));
  }
}
