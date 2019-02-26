package com.orderservice.orderservice.model.dao;

import com.orderservice.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders , Long> {

    //@Query("SELECT o FROM Orders o WHERE o.customer_id = :customer_id")
    //List<Orders> findAllByCustomerId(@Param("customer_id")long customer_id);
}
