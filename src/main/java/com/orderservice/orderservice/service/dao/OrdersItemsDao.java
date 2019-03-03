package com.orderservice.orderservice.service.dao;

import com.orderservice.orderservice.model.Orders;
import com.orderservice.orderservice.model.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersItemsDao extends JpaRepository<OrdersItem, Long> {

    @Query("select o from OrdersItem o where o.orders.id = :orderId")
    List<OrdersItem> findByOrderId(@Param("orderId") Long orderId);
}
