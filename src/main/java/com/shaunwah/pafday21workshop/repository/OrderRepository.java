package com.shaunwah.pafday21workshop.repository;

import com.shaunwah.pafday21workshop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    @Autowired
    JdbcTemplate template;

    public List<Order> getOrdersByCustomer(int customerId) {
        return template.query(
                "select * from orders where customer_id = ?",
                BeanPropertyRowMapper.newInstance(Order.class),
                customerId);
    }
}
