package com.customer.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {}
