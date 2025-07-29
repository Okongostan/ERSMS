// src/main/java/com/erms/controller/MenuItemController.java
package com.erms.controller;

import com.erms.model.MenuItem;
import com.erms.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuRepo;

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuRepo.findAll();
    }

    @PostMapping
    public MenuItem createMenuItem(@RequestBody MenuItem item) {
        return menuRepo.save(item);
    }

    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable Long id, @RequestBody MenuItem updatedItem) {
        return menuRepo.findById(id).map(item -> {
            item.setName(updatedItem.getName());
            item.setPrice(updatedItem.getPrice());
            item.setCategory(updatedItem.getCategory());
            item.setDescription(updatedItem.getDescription());
            item.setImagePath(updatedItem.getImagePath());
            return menuRepo.save(item);
        }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable Long id) {
        menuRepo.deleteById(id);
    }
}
