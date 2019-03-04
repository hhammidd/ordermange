package com.orderservice.orderservice.service.converter;


import com.orderservice.orderservice.controller.dto.OrdersTo;
import com.orderservice.orderservice.model.Customer;
import com.orderservice.orderservice.model.Orders;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdersMapperTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static OrdersMapper om;
    private static OrdersTo ordersTo;
    public static Orders orders;

    @BeforeClass
    public static void startup() {
        om = new OrdersMapper();
        ordersTo = new OrdersTo();
        orders = new Orders();
    }

    @Test
    public void convertToDtoTest() throws Exception {
        ordersTo.setId(11L);
        ordersTo.setCustomerId(10L);
        Date date = DATE_FORMAT.parse("2017-01-01");
        ordersTo.setRegistrationDate(date);
        ordersTo.setOrdersItems(null);

        orders.setId(11L);
        orders.setRegistrationDate(date);
        Customer customer = new Customer();
        customer.setId(10L);
        customer.setUsername("francesco");
        customer.setPhoneNo("23332332");
        orders.setCustomer(customer);

        OrdersTo ordersToAfter = om.convertToDto(orders);
        assertEquals(ordersTo.getCustomerId(), ordersToAfter.getCustomerId());
        assertEquals(ordersTo.getRegistrationDate(), ordersToAfter.getRegistrationDate());
        assertEquals(ordersTo.getId(), ordersToAfter.getId());
    }


    @Test
    public void convertToDomainTest() throws Exception {

        ordersTo.setId(11L);
        ordersTo.setCustomerId(10L);
        Date date = DATE_FORMAT.parse("2017-01-01");
        ordersTo.setRegistrationDate(date);
        ordersTo.setOrdersItems(null);

        orders.setId(11L);
        orders.setRegistrationDate(date);

        Customer customer = new Customer();
        customer.setId(10L);
        orders.setCustomer(customer);

        Orders ordersAfter = om.convertToDomain(ordersTo);
        assertEquals(orders.getCustomer().getId(), ordersAfter.getCustomer().getId());
        assertEquals(orders.getId(), ordersAfter.getId());
    }


}
