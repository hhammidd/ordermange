package com.orderservice.orderservice.controller;


import com.orderservice.orderservice.controller.dto.OrdersTo;
import com.orderservice.orderservice.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/{ordersId}")
    public OrdersTo getOrdersById(@PathVariable(name = "ordersId") long orderId) {
        return ordersService.getById(orderId);
    }

    @GetMapping
    public List<OrdersTo> getOrdersByCustomerId(@RequestParam(name = "customer_id", required = false) Long customerId) {
        if(customerId != null)
            return ordersService.getByCustomerId(customerId);
        return ordersService.getAll();
    }

    @PostMapping
    public OrdersTo createOrders(@RequestBody OrdersTo orders) {
        return ordersService.create(orders);
    }

    //only updates order properties not items
    @PutMapping("/{ordersId}")
    public OrdersTo updateOrders(@PathVariable(name = "ordersId") long ordersId, @RequestBody OrdersTo orders) {
        orders.setId(ordersId);
        return ordersService.update(orders);
    }
}
