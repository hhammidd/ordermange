package com.orderservice.orderservice.service.impl;

import com.orderservice.orderservice.dto.CustomerOrderDetailDto;
import com.orderservice.orderservice.dto.OrderListDto;
import com.orderservice.orderservice.model.Orders;
import com.orderservice.orderservice.model.dao.OrderRepository;
import com.orderservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderListDto> getListOfOrdersForCustomer(int customerId) {
        List<OrderListDto> orderListDtos = new ArrayList<>();
        List<Orders> ordersList = orderRepository.findAll();

        return orderListDtos;
    }

    @Override
    public List<CustomerOrderDetailDto>  getCustomerOrderDetail(int customerId) {
        List<CustomerOrderDetailDto> customerOrderDetailDtoList = null;
        List<Orders> orderCustomerList = null;

        orderCustomerList = orderRepository.findByIdAndCustomer(customerId);

        // TODO convert Orders List to CustomerOrderDetailDto List
        customerOrderDetailDtoList = convertToCustomerOrderDto(orderCustomerList);
        // TODO put the
        return customerOrderDetailDtoList;
    }

    private List<CustomerOrderDetailDto> convertToCustomerOrderDto(List<Orders> orderCustomerList) {
        List<CustomerOrderDetailDto> customerOrderDetailDtoList = new ArrayList<>();

        for (Orders orderObj : orderCustomerList){
            CustomerOrderDetailDto customerOrderDetailDtoObj = new CustomerOrderDetailDto();
            customerOrderDetailDtoObj.setOrderDate(orderObj.getRegistrationDate());

            customerOrderDetailDtoList.add(customerOrderDetailDtoObj);

        }
        return customerOrderDetailDtoList;
    }
}
