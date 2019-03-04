package com.orderservice.orderservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderservice.orderservice.controller.dto.OrdersItemTo;
import com.orderservice.orderservice.controller.dto.OrdersTo;
import com.orderservice.orderservice.service.OrdersService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(OrdersController.class)
public class OrdersControllerTest {

    @MockBean
    private OrdersService ordersService;

    @Autowired
    private MockMvc mockMvc;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void testGetOrdersById() throws Exception {
        OrdersTo mockOrdersTo = new OrdersTo();
        List<OrdersItemTo> mockOrdersItemToList = new ArrayList<>();
        OrdersItemTo mockOrderItemTo = new OrdersItemTo();

        mockOrderItemTo.setId(2L);
        mockOrderItemTo.setProductionId(4);
        mockOrderItemTo.setQuantity(22);
        mockOrdersItemToList.add(mockOrderItemTo);

        mockOrdersTo.setId(11L);
        mockOrdersTo.setCustomerId(10L);
        Date date = DATE_FORMAT.parse("2017-01-01");
        mockOrdersTo.setRegistrationDate(date);
        mockOrdersTo.setOrdersItems(mockOrdersItemToList);

        when(ordersService.getById(anyLong())).thenReturn(mockOrdersTo);
        mockMvc.perform(get("/orders/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId", is(10)))
                .andExpect(jsonPath("$.ordersItems[0].productionId", is(4)))
                .andExpect(jsonPath("$.ordersItems[0].quantity", is(22.0)));
    }

    @Test
    public void testgetOrdersByCustomerId() throws Exception {

        List<OrdersTo> mockOrdersToList = new ArrayList<>();
        OrdersTo mockOrdersTo = new OrdersTo();

        List<OrdersItemTo> mockOrdersItemToList = new ArrayList<>();
        OrdersItemTo mockOrderItemTo1 = new OrdersItemTo();
        mockOrderItemTo1.setId(2L);
        mockOrderItemTo1.setProductionId(4);
        mockOrderItemTo1.setQuantity(22);
        mockOrdersItemToList.add(mockOrderItemTo1);

        OrdersItemTo mockOrderItemTo2 = new OrdersItemTo();
        mockOrderItemTo2.setId(3L);
        mockOrderItemTo2.setProductionId(2);
        mockOrderItemTo2.setQuantity(100);
        mockOrdersItemToList.add(mockOrderItemTo2);

        mockOrdersTo.setId(11L);
        mockOrdersTo.setCustomerId(10L);
        Date date = DATE_FORMAT.parse("2017-01-01");
        mockOrdersTo.setRegistrationDate(date);
        mockOrdersTo.setOrdersItems(mockOrdersItemToList);

        mockOrdersToList.add(mockOrdersTo);

        when(ordersService.getByCustomerId(anyLong())).thenReturn(mockOrdersToList);
        mockMvc.perform(get("/orders?customer_id=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customerId", is(10)))
                .andExpect(jsonPath("$[0].ordersItems[0].productionId", is(4)))
                .andExpect(jsonPath("$[0].ordersItems[0].quantity", is(22.0)))
                .andExpect(jsonPath("$[0].ordersItems[1].productionId", is(2)))
                .andExpect(jsonPath("$[0].ordersItems[1].quantity", is(100.0)));

    }

    @Test
    public void testUpdateOrder() throws Exception {

        OrdersTo mockOrdersTo = new OrdersTo();
        mockOrdersTo.setId((long) 8);
        mockOrdersTo.setCustomerId((long) 3);

        OrdersTo ordersTo = new OrdersTo();
        ordersTo.setCustomerId(3L);
        ordersTo.setOrdersItems(null);

        when(ordersService.update(ordersTo)).thenReturn(mockOrdersTo);
        mockMvc.perform(put("/orders/8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockOrdersTo)))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateOrders() throws Exception {

        OrdersTo mockOrdersTo = new OrdersTo();
        OrdersItemTo mockOrderItemTo = new OrdersItemTo();

        mockOrderItemTo.setId(16L);
        mockOrderItemTo.setProductionId(3);
        mockOrderItemTo.setQuantity(200);

        List<OrdersItemTo> mockOrdersItemToList = new ArrayList<>();
        mockOrdersItemToList.add(mockOrderItemTo);

        mockOrdersTo.setId(17L);
        mockOrdersTo.setCustomerId(3L);
        mockOrdersTo.setOrdersItems(mockOrdersItemToList);

        when(ordersService.create(any())).thenReturn(mockOrdersTo);
        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockOrdersTo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId", is(3)))
                .andExpect(jsonPath("$.ordersItems[0].productionId", is(3)))
                .andExpect(jsonPath("$.ordersItems[0].quantity", is(200.0)));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
