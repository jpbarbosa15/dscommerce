package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {
    private Long productid;
    private String name;
    private Double price;
    private Integer quantity;


    public OrderItemDTO(Long productid, String name, Double price, Integer quantity, Double subTotal) {
        this.productid = productid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }
    public OrderItemDTO(OrderItem orderItem) {
        productid = orderItem.getProduct().getId();
        name = orderItem.getProduct().getName();
        price = orderItem.getPrice();
        quantity = orderItem.getQuantity();

    }

    public Long getProductid() {
        return productid;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal(){
        return price * quantity;
    }
}
