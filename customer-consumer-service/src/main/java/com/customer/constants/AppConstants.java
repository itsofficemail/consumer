package com.customer.constants;

public class AppConstants {

  private AppConstants() {}

  public static final String EMAIL_MASK_REGEX = "(?<=.{4}).(?=[^@]*?@)";
  public static final String EXCEPT_LAST_4 = ".(?=.{4})";
}
