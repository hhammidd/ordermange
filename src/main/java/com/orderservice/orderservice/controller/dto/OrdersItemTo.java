package com.orderservice.orderservice.controller.dto;

public class OrdersItemTo {
    private Long id;
    private long productionId;
    private double quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getProductionId() {
        return productionId;
    }

    public void setProductionId(long productionId) {
        this.productionId = productionId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
