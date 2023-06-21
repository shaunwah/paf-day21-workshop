package com.shaunwah.pafday21workshop.service;

import com.shaunwah.pafday21workshop.exception.ResourceNotFoundException;
import com.shaunwah.pafday21workshop.model.Order;
import com.shaunwah.pafday21workshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public List<Order> getOrdersByCustomer(int customerId) {
        List<Order> orders = repository.getOrdersByCustomer(customerId);

        if (orders != null && orders.size() > 0) {
            return orders;
        }
        throw new ResourceNotFoundException("Orders not found!");
    }
}
