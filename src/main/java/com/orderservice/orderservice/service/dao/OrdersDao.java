package com.orderservice.orderservice.service.dao;

import com.orderservice.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersDao extends JpaRepository<Orders, Long> {

    @Query("select o from Orders o where o.customer.id = :customerId")
    List<Orders> findByCustomerId(@Param("customerId") long customerId);
}
