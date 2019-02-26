package com.orderservice.orderservice.controller;

import com.orderservice.orderservice.dto.OrderListDto;
import com.orderservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

//TODO @RestController why not?
@Controller
@RequestMapping(value="/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    // TODO 1. GET /customers/3/orders should get the list of all orders from customer 3
    //@RequestMapping(value="/{customerId}/customer", method= RequestMethod.GET)
    //List<Order> findAll1(@RequestParam String customerId){}
    // TODO order_date order_id status

    @RequestMapping(value="/{customerId}/customer", method= RequestMethod.GET)
    List<OrderListDto> listOrdersOfCustomer(@PathVariable int customerId){
        List<OrderListDto> orderListDtos = new ArrayList<>();
        //TODO service fo setting results
        orderListDtos = orderService.getListOrderForCustomer(customerId);
        return orderListDtos;
    }

    // TODO GET which customer which productname and how many

    // TODO DELETE order by customerId

    // TODO UPDATE Order state


}
