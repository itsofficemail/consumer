package com.customer.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {}
