package com.customer.util;

import java.io.IOException;

import com.customer.exception.InvalidDataException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private JsonUtil() {}

  public static String objToString(Object object) {
    String stringObject = null;

    try {
      stringObject = OBJECT_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new InvalidDataException("Invalid Object data", e);
    }

    return stringObject;
  }

  public static <T> T stringToObj(String object, Class<T> valueType) {

    T t = null;

    try {
      t = OBJECT_MAPPER.readValue(object.getBytes(), valueType);
    } catch (IOException e) {
      throw new InvalidDataException("Invalid Object data", e);
    }
    return t;
  }
}
