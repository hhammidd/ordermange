package com.orderservice.orderservice.service;



import com.orderservice.orderservice.service.converter.OrdersItemMapper;
import com.orderservice.orderservice.service.converter.OrdersMapper;
import com.orderservice.orderservice.service.dao.OrdersDao;
import com.orderservice.orderservice.service.dao.OrdersItemsDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;


@Service
public class OrdersServiceTest  {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersItemMapper ordersItemMapper;

    @MockBean
    private OrdersDao ordersDao;

    @MockBean
    private OrdersItemsDao ordersItemsDao;

    @Test
    public void test() {
        testGetById();
        testGetByCustomerId();
        testGetAll();
        testCreate();
        testUpdate();
        testDeleteOredr();
    }

    private void testGetByCustomerId() {
    }

    private void testGetById() {
        //TODO
    }

    private void testGetAll() {
        //TODO
    }

    private void testCreate() {
        //TODO
    }

    private void testUpdate() {
        //TODO
    }

    private void testDeleteOredr() {
        //TODO
    }

}
