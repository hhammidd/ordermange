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

    /**
     * Get the order by order id
     *
     * @param orderId
     * @return order object
     */

    @GetMapping("/{ordersId}")
    public OrdersTo getOrdersById(@PathVariable(name = "ordersId") long orderId) {
        return ordersService.getById(orderId);
    }


    /**
     * List of all orders by specific customer id
     *
     * @param customerId
     * @return List of the orders
     */

    @GetMapping
    public List<OrdersTo> getOrdersByCustomerId(@RequestParam(name = "customer_id", required = false) Long customerId) {
        if (customerId != null)
            return ordersService.getByCustomerId(customerId);
        return ordersService.getAll();
    }


    /**
     * take an object of orders by a customer and
     * save order in oredrs and  orders id
     *
     * @param orders
     * @return ordersTo the order and order item which created
     */

    @PostMapping
    public OrdersTo createOrders(@RequestBody OrdersTo orders) {
        return ordersService.create(orders);
    }


    /**
     * only updates order properties not items and create if not existed
     *
     * @param ordersId
     * @param orders
     * @return
     */

    @PutMapping("/{ordersId}")
    public OrdersTo updateOrders(@PathVariable(name = "ordersId") long ordersId, @RequestBody OrdersTo orders) {
        orders.setId(ordersId);
        return ordersService.update(orders);
    }


    /**
     * Delete order by order id and delete orders_item with same order id
     *
     * @param ordersId
     * @return boolean
     * true is deleted
     * false is not deleted
     */

    @DeleteMapping("/{ordersId}")
    public boolean deleteOrder(@PathVariable(name = "ordersId") long ordersId) {
        return ordersService.deleteOrder(ordersId);
    }
}
