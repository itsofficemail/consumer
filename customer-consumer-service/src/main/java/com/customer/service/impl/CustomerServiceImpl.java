package com.customer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.respository.CustomerRepository;
import com.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

  @Autowired private CustomerRepository userRepository;

  @Override
  public Customer save(Customer user) {
    return userRepository.save(user);
  }
}
