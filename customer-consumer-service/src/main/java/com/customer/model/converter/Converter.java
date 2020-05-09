package com.customer.model.converter;

public interface Converter<I, O> {

  O convert(I i);
}
