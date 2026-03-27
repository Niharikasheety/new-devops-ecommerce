package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long id, String status) {
        return orderRepository.findById(id).map(o -> {
            o.setStatus(status);
            return orderRepository.save(o);
        }).orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
