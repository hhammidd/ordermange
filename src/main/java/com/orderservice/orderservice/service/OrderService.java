package com.orderservice.orderservice.service;

import com.orderservice.orderservice.dto.OrderListDto;
import com.orderservice.orderservice.model.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderService {


    List<OrderListDto> getListOrderForCustomer(int customerId);

}
