package com.customer.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.ErrorLog;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, String> {}
