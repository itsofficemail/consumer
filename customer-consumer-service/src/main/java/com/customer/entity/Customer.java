package com.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.customer.model.converter.CustomerEncryptionConverter;
import com.customer.model.converter.CustomerStatusConverter;

@Entity
public class Customer extends Persistable {

  /** */
  private static final long serialVersionUID = 8940792729109899387L;

  public Customer() {
    super();
  }

  @Column(name = "CUSTOMER_NUMBER", nullable = false, updatable = false, length = 10)
  private String customerNumber;

  @Column(name = "FIRST_NAME", nullable = false, length = 50)
  private String firstName;

  @Column(name = "LAST_NAME", nullable = false, length = 50)
  private String lastName;

  @Convert(converter = CustomerEncryptionConverter.class)
  @Column(name = "DOB", nullable = false, length = 256)
  private String birthDate;

  @Column(name = "COUNTRY", nullable = false, length = 50)
  private String country;

  @Column(name = "COUNTRY_CODE", nullable = false, length = 2)
  private String countryCode;

  @Convert(converter = CustomerEncryptionConverter.class)
  @Column(name = "MOB_NUM", nullable = false, length = 256)
  private String mobileNumber;

  @Convert(converter = CustomerEncryptionConverter.class)
  @Column(name = "EMAIL", nullable = false, length = 256)
  private String email;

  @Convert(converter = CustomerStatusConverter.class)
  @Column(name = "CUSTOMER_STATUS", nullable = false, length = 1)
  private CustomerStatus customerStatus;

  @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
  private Address address;

  @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private AuditLog auditLog;
  
  @Version private long version;

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerStatus getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatus customerStatus) {
    this.customerStatus = customerStatus;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public AuditLog getAuditLog() {
    return auditLog;
  }

  public void setAuditLog(AuditLog auditLog) {
    this.auditLog = auditLog;
  }
}
