package com.orderservice.orderservice.service.converter;

import com.orderservice.orderservice.controller.dto.OrdersItemTo;
import com.orderservice.orderservice.model.OrdersItem;
import com.orderservice.orderservice.model.Production;
import org.springframework.stereotype.Component;

@Component
public class OrdersItemMapperTest implements Mapper<OrdersItem, OrdersItemTo> {
    @Override
    public OrdersItemTo convertToDto(OrdersItem ordersItem) {
        OrdersItemTo to = new OrdersItemTo();
        to.setId(ordersItem.getId());
        to.setQuantity(ordersItem.getQuantity());
        to.setProductionId(ordersItem.getProduction().getId());
        return to;
    }

    @Override
    public OrdersItem convertToDomain(OrdersItemTo ordersItemTo) {
        OrdersItem i = new OrdersItem();
        i.setId(ordersItemTo.getId());
        i.setQuantity(ordersItemTo.getQuantity());
        Production production = new Production();
        production.setId(ordersItemTo.getProductionId());
        i.setProduction(production);
        return i;
    }
}
