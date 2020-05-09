package com.customer.model.converter;

import com.customer.entity.Address;
import com.customer.entity.AuditLog;
import com.customer.entity.Customer;
import com.customer.entity.CustomerStatus;
import com.customer.model.CustomerDTO;
import com.customer.util.ConverterUtil;
import com.customer.util.JsonUtil;

public class CustomerEntityConverter implements Converter<CustomerDTO, Customer> {

  @Override
  public Customer convert(CustomerDTO customerData) {

    String payload = JsonUtil.objToString(ConverterUtil.mask(customerData));
    
    CustomerStatus customerStatus =
        CustomerStatus.fromValue(customerData.getCustomerStatus().toString());

    Customer customer = new Customer();
    customer.setCustomerNumber(customerData.getCustomerNumber());
    customer.setFirstName(customerData.getFirstName());
    customer.setLastName(customerData.getLastName());
    customer.setBirthDate(customerData.getBirthDate());
    customer.setCountry(customerData.getCountry());
    customer.setCountryCode(customerData.getCountryCode());
    customer.setMobileNumber(customerData.getMobileNumber());
    customer.setEmail(customerData.getEmail());
    customer.setCustomerStatus(customerStatus);

    Address address = new Address();
    address.setAddressLine1(customerData.getAddress().getAddressLine1());
    address.setAddressLine2(customerData.getAddress().getAddressLine2());
    address.setStreet(customerData.getAddress().getStreet());
    address.setPostalCode(customerData.getAddress().getPostalCode());
    address.setCustomer(customer);
    customer.setAddress(address);

    AuditLog auditLog = new AuditLog();
    auditLog.setPayload(payload);
    auditLog.setCustomer(customer);
    customer.setAuditLog(auditLog);

    return customer;
  }
}
