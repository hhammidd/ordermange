package com.orderservice.orderservice.controller.dto;

import java.util.Date;

public class OrderListDto {
    private Date orderDate;
    private long customerId;
    private String status;

    public OrderListDto() {
    }

    public OrderListDto(Date orderDate, long customerId, String status) {
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
