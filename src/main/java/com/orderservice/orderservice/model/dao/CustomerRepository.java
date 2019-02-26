package com.orderservice.orderservice.model.dao;

import com.orderservice.orderservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
