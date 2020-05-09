package com.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ERROR_LOG")
public class ErrorLog extends Persistable {

  /** */
  private static final long serialVersionUID = 1072143544326468798L;

  @Column(name = "ERROR_TYPE", length = 256)
  private String errorType;

  @Column(name = "ERROR_DESCRIPTION", length = 1032)
  private String errorDescription;

  @Column(length = 2064)
  private String payload;

  public ErrorLog() {
    super();
  }

  public ErrorLog(String errorType, String errorDescription, String payload) {
    super();
    this.errorType = errorType;
    this.errorDescription = errorDescription;
    this.payload = payload;
  }

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }
}
