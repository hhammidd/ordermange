package com.orderservice.orderservice.service.converter;


import com.orderservice.orderservice.controller.dto.OrdersItemTo;
import com.orderservice.orderservice.controller.dto.OrdersTo;
import com.orderservice.orderservice.model.Customer;
import com.orderservice.orderservice.model.Orders;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersMapperTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void convertToDtoTest() throws Exception{
        OrdersTo ordersTo = new OrdersTo();
        List<OrdersItemTo> ordersItemToList = new ArrayList<>();
        OrdersItemTo orderItemTo = new OrdersItemTo();

        orderItemTo.setId((long) 2);
        orderItemTo.setProductionId(4);
        orderItemTo.setQuantity(22);
        ordersItemToList.add(orderItemTo);

        ordersTo.setId((long) 11);
        ordersTo.setCustomerId((long) 10);
        Date date = DATE_FORMAT.parse("2017-01-01");
        ordersTo.setRegistrationDate(date);
        ordersTo.setOrdersItems(ordersItemToList);


        Orders orders = new Orders();
        orders.setId((long) 11);
        orders.setRegistrationDate(date);

        Customer customer = new Customer();
        customer.setId((long) 10);
        orders.setCustomer(customer);


         assertEquals(ordersMapper.convertToDto(orders), ordersTo);

    }
}
