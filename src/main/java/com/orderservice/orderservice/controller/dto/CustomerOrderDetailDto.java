package com.orderservice.orderservice.controller.dto;

import java.util.Date;

public class CustomerOrderDetailDto {

    private Date orderDate;
    private String status;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
