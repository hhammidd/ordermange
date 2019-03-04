package com.orderservice.orderservice.service;



import com.orderservice.orderservice.controller.OrdersController;
import com.orderservice.orderservice.service.converter.OrdersItemMapper;
import com.orderservice.orderservice.service.converter.OrdersMapper;
import com.orderservice.orderservice.service.dao.OrdersDao;
import com.orderservice.orderservice.service.dao.OrdersItemsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(OrdersService.class)
@SpringBootTest
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
    public void testGetByCustomerId() {
    }

    @Test
    public void testGetById() {
    }

    @Test
    public void testGetAll() {
    }

    @Test
    public void testCreate() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDeleteOredr() {
    }

}
