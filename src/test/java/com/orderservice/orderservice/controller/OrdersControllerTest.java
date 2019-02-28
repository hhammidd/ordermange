package com.orderservice.orderservice.controller;

import com.orderservice.orderservice.controller.dto.OrdersItemTo;
import com.orderservice.orderservice.controller.dto.OrdersTo;
import com.orderservice.orderservice.service.OrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(OrdersController.class)
public class OrdersControllerTest {

    @MockBean
    private OrdersService ordersService;
    @Autowired
    private MockMvc mockMvc;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void getOrders() throws Exception {

        Date date = DATE_FORMAT.parse("2017-01-01");

        OrdersTo mockOrdersTo = new OrdersTo();
        OrdersItemTo mockOrderItemTo = new OrdersItemTo();

        mockOrderItemTo.setId((long) 1);
        mockOrderItemTo.setProductionId(1);
        mockOrderItemTo.setQuantity(22);

        List<OrdersItemTo> mockOrdersItemToList = new ArrayList<>();
        mockOrdersItemToList.add(mockOrderItemTo);

        mockOrdersTo.setId((long) 1);
        mockOrdersTo.setCustomerId((long) 1);
        mockOrdersTo.setRegistrationDate(date);
        mockOrdersTo.setOrdersItems(mockOrdersItemToList);

        given(ordersService.getById(1)).willReturn(mockOrdersTo);
        this.mockMvc.perform(get("/orders/1")).andExpect(status().isOk());
    }




}
