package com.customer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.ErrorLog;
import com.customer.respository.ErrorLogRepository;
import com.customer.service.ErrorLogService;

@Service
public class ErrorLogServiceImpl implements ErrorLogService {

  private static final Logger LOG = LoggerFactory.getLogger(ErrorLogServiceImpl.class);

  @Autowired private ErrorLogRepository errorLogRepository;

  @Override
  public ErrorLog save(ErrorLog errorLog) {
    return errorLogRepository.save(errorLog);
  }
}
