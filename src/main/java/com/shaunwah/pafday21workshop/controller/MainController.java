package com.shaunwah.pafday21workshop.controller;

import com.shaunwah.pafday21workshop.model.Customer;
import com.shaunwah.pafday21workshop.model.Order;
import com.shaunwah.pafday21workshop.service.CustomerService;
import com.shaunwah.pafday21workshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(
            @RequestParam(defaultValue = "0") String offset,
            @RequestParam(defaultValue = "5") String limit) {
        return customerService.getCustomers(Integer.parseInt(offset), Integer.parseInt(limit));
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable String id) {
        Optional<Customer> result = customerService.getCustomer(Integer.parseInt(id));
        if (result.isPresent()) {
            return result.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/customer/{id}/orders")
    public List<Order> getOrdersByCustomer(@PathVariable String id) {
        List<Order> result = orderService.getOrdersByCustomer(Integer.parseInt(id));
        if (result.size() > 0) {
            return result;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
