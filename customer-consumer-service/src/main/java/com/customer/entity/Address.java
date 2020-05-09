package com.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Address extends Persistable {

  /** */
  private static final long serialVersionUID = -7988116221382929870L;

  public Address() {
    super();
  }

  @Column(name = "ADDRESS_LINE_1", nullable = false, length = 50)
  private String addressLine1;

  @Column(name = "ADDRESS_LINE_2", nullable = true, length = 50)
  private String addressLine2;

  @Column(name = "STREET", nullable = true, length = 50)
  private String street;

  @Column(name = "POSTAL_CODE", nullable = true, length = 5)
  private String postalCode;

  @Version private long version;

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "CUSTOMER_ID", nullable = false)
  private Customer customer;

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }
}
