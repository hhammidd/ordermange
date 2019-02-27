package com.orderservice.orderservice.service.converter;


import com.orderservice.orderservice.controller.dto.OrdersTo;
import com.orderservice.orderservice.model.Customer;
import com.orderservice.orderservice.model.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrdersMapper implements Mapper<Orders, OrdersTo> {
    @Override
    public OrdersTo convertToDto(Orders orders) {
        OrdersTo to = new OrdersTo();
        to.setCustomerId(orders.getCustomer().getId());
        to.setId(orders.getId());
        to.setRegistrationDate(orders.getRegistrationDate());
        return to;
    }

    @Override
    public Orders convertToDomain(OrdersTo ordersTo) {
        Orders orders = new Orders();
        orders.setId(ordersTo.getId());
        Customer customer = new Customer();
        customer.setId(ordersTo.getCustomerId());
        orders.setCustomer(customer);
        return orders;
    }
}
