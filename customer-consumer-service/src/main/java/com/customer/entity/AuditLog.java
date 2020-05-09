package com.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUDIT_LOG")
public class AuditLog extends Persistable {

  /** */
  private static final long serialVersionUID = 571064843389738326L;

  public AuditLog() {
    super();
  }

  public AuditLog(Customer customer, String payload) {
    super();
    this.customer = customer;
    this.payload = payload;
  }

  @OneToOne
  @JoinColumn(name = "CUSTOMER_NUMBER", nullable = false)
  private Customer customer;

  @Column(length = 2040)
  private String payload;

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }
}
