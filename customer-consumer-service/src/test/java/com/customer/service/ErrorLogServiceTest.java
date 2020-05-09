package com.customer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.entity.ErrorLog;
import com.customer.respository.ErrorLogRepository;
import com.customer.service.impl.ErrorLogServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ErrorLogServiceTest {

  @Mock ErrorLogRepository errorLogRepository;
  @InjectMocks ErrorLogServiceImpl errorLogService;

  private ErrorLog errorLog = null;

  @Before
  public void setupData() {
    errorLog =
        new ErrorLog("NullPointerException", "Object passed is null", "Customer Data Payload");
  }

  @Test
  public void saveTest() {

    when(errorLogRepository.save(errorLog)).thenReturn(errorLog);

    ErrorLog actualErrorLog = errorLogService.save(errorLog);

    verify(errorLogRepository, times(1)).save(errorLog);
    assertNotNull(actualErrorLog);
    assertEquals(errorLog, actualErrorLog);
  }
}
