package com.orderservice.orderservice.dao;

import com.orderservice.orderservice.model.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersItemsDao extends JpaRepository<OrdersItem, Long> {

}
