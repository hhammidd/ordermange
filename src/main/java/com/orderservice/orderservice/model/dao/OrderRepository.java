package com.orderservice.orderservice.model.dao;

import com.orderservice.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders , Integer> {

    //@Query("SELECT o FROM Orders o WHERE o.customer.customer_id = 1")
    //Orders findByIdAndCustomer(@Param("id") int id , @Param("customerId") int customerId);

    //Orders findByCustomer(int customer_id);

    //@Query("SELECT o FROM Orders o WHERE o.customer.customerId = :customerId")
    //public List<Orders> findByIdAndCustomer(@Param("customerId") int customerId);


    //public List<Orders> findByCustomerId(int customerId);
}
