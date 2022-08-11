package com.example.circle.rabbitmq.model;

import java.io.Serializable;

public class Product implements Serializable {

    private Long id;
    private String productName;
    private Integer status;
    private Double price;
    private String productDesc;
    private String caption;

    public Product() {
    }

    public Product(Long id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                "productName=" + productName +
                '}';
    }
}
