package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;
    private String imgUrl;


    public OrderItemDTO(Long productid, String name, Double price, Integer quantity, Double subTotal, String imgUrl) {
        this.productId = productid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }
    public OrderItemDTO(OrderItem orderItem) {
        productId = orderItem.getProduct().getId();
        name = orderItem.getProduct().getName();
        price = orderItem.getPrice();
        quantity = orderItem.getQuantity();
        imgUrl = orderItem.getProduct().getImgUrl();

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Long getProductId() {
        return productId;
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
