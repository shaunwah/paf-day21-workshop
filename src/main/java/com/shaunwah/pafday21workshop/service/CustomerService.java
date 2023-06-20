package com.shaunwah.pafday21workshop.service;

import com.shaunwah.pafday21workshop.model.Customer;
import com.shaunwah.pafday21workshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public List<Customer> getCustomers(int offset, int limit) {
        return repository.getCustomers(offset, limit);
    }

    public Optional<Customer> getCustomer(int id) {
        return repository.getCustomer(id);
    }
}
