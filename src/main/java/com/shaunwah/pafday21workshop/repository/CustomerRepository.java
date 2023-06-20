package com.shaunwah.pafday21workshop.repository;

import com.shaunwah.pafday21workshop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {
    @Autowired
    JdbcTemplate template;

    public List<Customer> getCustomers(int offset, int limit) {
        return template.query("select * from customers limit ? offset ?",
                BeanPropertyRowMapper.newInstance(Customer.class),
                limit,
                offset);
    }

    public Optional<Customer> getCustomer(int id) {
        try {
            return Optional.of(template.queryForObject("select * from customers where id = ?", BeanPropertyRowMapper.newInstance(Customer.class), id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
