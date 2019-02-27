package com.orderservice.orderservice.service;

import com.orderservice.orderservice.dto.CustomerOrderDetailDto;
import com.orderservice.orderservice.dto.OrderListDto;

import java.util.List;

public interface OrderService {

    List<OrderListDto> getListOfOrdersForCustomer(int customerId);
    List<CustomerOrderDetailDto> getCustomerOrderDetail( int customer_id);
}
