package com.customer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.customer.entity.Customer;
import com.customer.entity.ErrorLog;
import com.customer.exception.GeneralException;
import com.customer.model.CustomerDTO;
import com.customer.service.CustomerService;
import com.customer.service.ErrorLogService;
import com.customer.util.ConverterUtil;
import com.customer.util.JsonUtil;

@Component
public class KafkaConsumerListener {

  private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerListener.class);

  private static final String CUSTOMER_TOPIC = "customer-topic";

  @Autowired private CustomerService customerService;
  @Autowired private ErrorLogService errorLogService;

  @KafkaListener(
      topics = CUSTOMER_TOPIC,
      groupId = "UserGroup",
      containerFactory = "kafkaListenerContainerFactory")
  public void consumeUser(CustomerDTO customerDTO) {

    String payload = null;

    try {

      payload = JsonUtil.objToString(ConverterUtil.mask(customerDTO));

      LOG.info("Received customer data from kafka {}", payload);

      Customer customer = ConverterUtil.toEntity(customerDTO);
      customerService.save(customer);

    } catch (Exception e) {
      ErrorLog errorLog = new ErrorLog(e.getClass().getName(), e.getMessage(), payload);
      errorLogService.save(errorLog);
      throw new GeneralException("Invalid customer data", e);
    }
  }
}
