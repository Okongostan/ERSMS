// src/main/java/com/erms/repository/MenuItemRepository.java
package com.erms.repository;

import com.erms.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
