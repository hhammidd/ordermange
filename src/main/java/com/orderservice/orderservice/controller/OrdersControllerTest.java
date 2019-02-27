package com.orderservice.orderservice.controller;

import com.orderservice.orderservice.dto.CustomerOrderDetailDto;
import com.orderservice.orderservice.dto.OrderListDto;
import com.orderservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//TODO @RestController why not?
@RestController
@RequestMapping(value="/orders")
public class OrdersControllerTest {

    @Autowired
    private OrderService orderService;

    // TODO 1. GET /customers/3/orders should get the list of all orders from customer 3
    //@RequestMapping(value="/{customerId}/customer", method= RequestMethod.GET)
    //List<Order> findAll1(@RequestParam String customerId){}
    // TODO order_date order_id status

    @GetMapping
     public List<OrderListDto> listOrdersOfCustomer(@RequestParam(value = "customerid") int customerid){
            List<OrderListDto> orderListDtos = new ArrayList<>();
            //TODO service fo setting results
            orderListDtos = orderService.getListOfOrdersForCustomer(customerid);
            return orderListDtos;

    }
    // TODO take the status and order date and unit price of the special order id and product id
    @GetMapping(value = "/customer/{customer_id}")
    public List<CustomerOrderDetailDto> getCustomerOrderDetail( @PathVariable int customer_id) {
        List<CustomerOrderDetailDto> customerOrderDetailDtos = new ArrayList<>();
        customerOrderDetailDtos = orderService.getCustomerOrderDetail(customer_id);
        return customerOrderDetailDtos;
    }

    // TODO GET which customer which productname and how many

    // TODO DELETE order by customerId

    // TODO UPDATE Order state


}
