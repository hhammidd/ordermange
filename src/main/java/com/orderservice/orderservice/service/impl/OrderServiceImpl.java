package com.orderservice.orderservice.service.impl;

import com.orderservice.orderservice.dto.OrderListDto;
import com.orderservice.orderservice.model.Orders;
import com.orderservice.orderservice.model.dao.OrderRepository;
import com.orderservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderListDto> getListOrderForCustomer(int customerId) {
        List<OrderListDto> orderListDtos = new ArrayList<>();
        List<Orders> ordersList = orderRepository.findAll();

        return orderListDtos;
    }
}
