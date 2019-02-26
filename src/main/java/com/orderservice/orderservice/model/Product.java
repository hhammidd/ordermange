package com.orderservice.orderservice.model;

import org.hibernate.validator.constraints.EAN;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_DESC")
    private String productDEsc;

    public Set<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(Set<OrderProduct> orderProductList) {
        this.orderProductList = orderProductList;
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "product")
    private Set<OrderProduct> orderProductList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDEsc() {
        return productDEsc;
    }

    public void setProductDEsc(String productDEsc) {
        this.productDEsc = productDEsc;
    }
}
