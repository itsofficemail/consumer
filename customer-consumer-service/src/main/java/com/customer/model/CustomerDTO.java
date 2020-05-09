package com.customer.model;

public class CustomerDTO {

  private String customerNumber;
  private String firstName;
  private String lastName;
  private String birthDate;
  private String country;
  private String countryCode;
  private String mobileNumber;
  private String email;
  private CustomerStatusDTO customerStatus;
  private AddressDTO address;

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

  public CustomerStatusDTO getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatusDTO customerStatus) {
    this.customerStatus = customerStatus;
  }

  public AddressDTO getAddress() {
    return address;
  }

  public void setAddress(AddressDTO address) {
    this.address = address;
  }
}
