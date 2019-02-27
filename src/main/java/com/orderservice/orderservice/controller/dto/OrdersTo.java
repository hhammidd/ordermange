package com.orderservice.orderservice.controller.dto;

import java.util.Date;
import java.util.List;

public class OrdersTo {
    private Long id;
    private Date registrationDate;
    private Long customerId;
    private List<OrdersItemTo> ordersItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrdersItemTo> getOrdersItems() {
        return ordersItems;
    }

    public void setOrdersItems(List<OrdersItemTo> ordersItems) {
        this.ordersItems = ordersItems;
    }
}
