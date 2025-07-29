// src/main/java/com/erms/controller/OrderController.java
package com.erms.controller;

import com.erms.model.Order;
import com.erms.model.User;
import com.erms.model.MenuItem;
import com.erms.repository.OrderRepository;
import com.erms.repository.UserRepository;
import com.erms.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(
            @RequestParam Long userId,
            @RequestParam Long menuItemId,
            @RequestParam int quantity) {
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        
        Order order = new Order();
        order.setUser(user);
        order.setMenuItem(menuItem);
        order.setQuantity(quantity);
        order.setStatus(Order.Status.PENDING);
        
        return orderRepository.save(order);
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        return orderRepository.findById(id).map(order -> {
            order.setStatus(Order.Status.valueOf(status.toUpperCase()));
            return orderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}
