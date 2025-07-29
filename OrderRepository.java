// src/main/java/com/erms/repository/OrderRepository.java
package com.erms.repository;

import com.erms.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
