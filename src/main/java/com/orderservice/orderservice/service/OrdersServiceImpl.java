package com.orderservice.orderservice.service;


import com.orderservice.orderservice.service.dao.OrdersDao;
import com.orderservice.orderservice.service.dao.OrdersItemsDao;
import com.orderservice.orderservice.controller.dto.OrdersItemTo;
import com.orderservice.orderservice.controller.dto.OrdersTo;
import com.orderservice.orderservice.service.converter.OrdersItemMapper;
import com.orderservice.orderservice.service.converter.OrdersMapper;
import com.orderservice.orderservice.model.Orders;
import com.orderservice.orderservice.model.OrdersItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersItemMapper ordersItemMapper;

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private OrdersItemsDao ordersItemsDao;

    @Override
    public OrdersTo getById(long id) {
        return ordersMapper.convertToDto(ordersDao.findById(id).get());
    }

    @Override
    public List<OrdersTo> getByCustomerId(long customerId) {
        List<OrdersTo> oredrsToList = new ArrayList<>();
        for (Orders orders : ordersDao.findByCustomerId(customerId)) {
            OrdersTo ordersTo = ordersMapper.convertToDto(orders);
            List<OrdersItemTo> ordersItemTos = ordersItemsDao.findByOrderId(orders.getId()).stream().map(
                    o -> ordersItemMapper.convertToDto(o)).collect(Collectors.toList());
            ordersTo.setOrdersItems(ordersItemTos);
            oredrsToList.add(ordersTo);
        }
        return oredrsToList;
    }

    @Override
    public List<OrdersTo> getAll() {
        return ordersDao.findAll().stream().map(
                o -> ordersMapper.convertToDto(o)).collect(Collectors.toList());
    }

    @Override
    public OrdersTo create(OrdersTo ordersTo) {
        //TODO check validity
        Orders orders = ordersMapper.convertToDomain(ordersTo);
        orders.setId(null);
        orders.setRegistrationDate(new Date());
        final Orders res = ordersDao.save(orders);
        List<OrdersItemTo> ordersItemTos = new ArrayList<>(ordersTo.getOrdersItems().size());
        ordersTo.getOrdersItems().forEach(i -> {
            OrdersItem oi = ordersItemMapper.convertToDomain(i);
            oi.setId(null);
            oi.setOrders(res);
            oi = ordersItemsDao.save(oi);
            ordersItemTos.add(ordersItemMapper.convertToDto(oi));
        });
        OrdersTo resTo = ordersMapper.convertToDto(res);
        resTo.setOrdersItems(ordersItemTos);
        return resTo;
    }

    @Override
    public OrdersTo update(OrdersTo ordersTo) {
        //TODO check validity
        Orders orders = ordersMapper.convertToDomain(ordersTo);
        orders.setRegistrationDate(new Date());
        return ordersMapper.convertToDto(ordersDao.save(orders));
    }

    @Override
    public boolean deleteOrder(long ordersId) {
        Optional<Orders> orderObj = ordersDao.findById(ordersId);
        if (orderObj != null) {
            List<OrdersItem> ordersItemList = ordersItemsDao.findByOrderId(ordersId);
            if (ordersItemList != null) {
                ordersItemList.stream().forEach(
                        oi -> ordersItemsDao.delete(oi));
            }
            ordersDao.deleteById(ordersId);
            return true;
        } else {
            return false;
        }
    }
}
