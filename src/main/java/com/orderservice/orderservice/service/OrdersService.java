package com.orderservice.orderservice.service;

import com.orderservice.orderservice.controller.dto.OrdersTo;

import java.util.List;

public interface OrdersService {

    OrdersTo getById(long id);

    List<OrdersTo> getByCustomerId(long customerId);

    List<OrdersTo> getAll();

    OrdersTo create(OrdersTo orders);

    OrdersTo update(OrdersTo orders);
}
