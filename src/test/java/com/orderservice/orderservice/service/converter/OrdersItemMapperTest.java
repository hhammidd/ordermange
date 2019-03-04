package com.orderservice.orderservice.service.converter;


import com.orderservice.orderservice.controller.dto.OrdersItemTo;
import com.orderservice.orderservice.model.Orders;
import com.orderservice.orderservice.model.OrdersItem;
import com.orderservice.orderservice.model.Production;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class OrdersItemMapperTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static OrdersItemMapper oim;
    private static OrdersItem ordersItem;
    public static OrdersItemTo ordersItemTo;

    @BeforeClass
    public static void startup() {
        oim = new OrdersItemMapper();
        ordersItem = new OrdersItem();
        ordersItemTo = new OrdersItemTo();
    }

    @Test
    public void convertToDtoTest() {

        ordersItemTo.setId(1L);
        ordersItemTo.setProductionId(5);
        ordersItemTo.setQuantity(100);

        ordersItem.setId(1L);
        Orders orders = new Orders();
        orders.setId(1L);
        ordersItem.setOrders(null);
        Production production = new Production();
        production.setId(5L);
        ordersItem.setProduction(production);
        ordersItem.setQuantity(100);

        OrdersItemTo ordersItemToAfter = oim.convertToDto(ordersItem);
        assertEquals(ordersItemTo.getId(), ordersItemToAfter.getId());
        assertEquals(ordersItemTo.getProductionId(), ordersItemToAfter.getProductionId());
    }

    @Test
    public void convertToDomainTest() {

        ordersItem.setId(1L);
        ordersItem.setQuantity(120);
        Orders orders = new Orders();
        orders.setId(2L);
        ordersItem.setOrders(orders);
        Production production = new Production();
        production.setId(3L);
        ordersItem.setProduction(production);

        ordersItemTo.setId(1L);
        ordersItemTo.setQuantity(120);
        ordersItemTo.setProductionId(3);

        OrdersItem ordersItemAfter = oim.convertToDomain(ordersItemTo);
        assertEquals(ordersItem.getId(), ordersItemAfter.getId());
        assertEquals(ordersItem.getProduction().getId(), ordersItemAfter.getProduction().getId());
    }
}
