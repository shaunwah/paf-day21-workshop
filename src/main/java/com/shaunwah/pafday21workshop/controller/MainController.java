package com.shaunwah.pafday21workshop.controller;

import com.shaunwah.pafday21workshop.model.Customer;
import com.shaunwah.pafday21workshop.model.Order;
import com.shaunwah.pafday21workshop.service.CustomerService;
import com.shaunwah.pafday21workshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(defaultValue = "0") String offset,
            @RequestParam(defaultValue = "5") String limit) {
        List<Customer> result = customerService.getCustomers(Integer.parseInt(offset), Integer.parseInt(limit));
        return ResponseEntity.ofNullable(result);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        Customer result = customerService.getCustomer(Integer.parseInt(id));
        return ResponseEntity.ofNullable(result);
    }

    @GetMapping("/customer/{id}/orders")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable String id) {
        List<Order> result = orderService.getOrdersByCustomer(Integer.parseInt(id));
        return ResponseEntity.ofNullable(result);
    }
}
