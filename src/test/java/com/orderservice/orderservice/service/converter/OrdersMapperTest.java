package com.orderservice.orderservice.service.converter;


import com.orderservice.orderservice.controller.dto.OrdersItemTo;
import com.orderservice.orderservice.controller.dto.OrdersTo;
import com.orderservice.orderservice.model.Customer;
import com.orderservice.orderservice.model.Orders;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersMapperTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static OrdersMapper om;
    private static OrdersTo ordersTo;
    public static Orders orders;

    @BeforeClass
    public static void startup(){
        om = new OrdersMapper();
        ordersTo = new OrdersTo();
        orders = new Orders();
    }

    @Before
    public void init() throws Exception{
        ordersTo.setId((long) 11);
        ordersTo.setCustomerId((long) 10);
        Date date = DATE_FORMAT.parse("2017-01-01");
        ordersTo.setRegistrationDate(date);
        ordersTo.setOrdersItems(null);

        orders.setId((long) 11);
        orders.setRegistrationDate(date);

        Customer customer = new Customer();
        customer.setId((long) 10);
        customer.setUsername("francesco");
        customer.setPhoneNo("23332332");
        orders.setCustomer(customer);
    }

    @Test
    public void convertToDtoTest() {

        OrdersTo ordersToAfter = om.convertToDto(orders);
        assertEquals(ordersTo.getCustomerId(), ordersToAfter.getCustomerId());
        assertEquals(ordersTo.getRegistrationDate(), ordersToAfter.getRegistrationDate());
        assertEquals(ordersTo.getId(), ordersToAfter.getId());
    }



}
