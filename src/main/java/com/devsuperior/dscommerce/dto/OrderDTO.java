package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;

import java.util.List;


public class OrderDTO {
    private Long id;
    private Instant moment;
    private OrderStatus status;
    private UserMinDTO client;
    private PaymentDTO payment;
    @NotEmpty(message = "Deve ter pelo menos um produto")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, UserMinDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO(Order order) {
        id = order.getId();
        moment = order.getMoment();
        status = order.getStatus();
        client = new UserMinDTO(order.getClient());
        payment = (order.getPayment() == null) ? null : new PaymentDTO(order.getPayment());
        for(OrderItem x : order.getItems()){
            items.add(new OrderItemDTO(x));
        }
    }


    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public UserMinDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal(){
        Double sum = 0.0;
        for(OrderItemDTO x : items){
            sum =+ x.getSubTotal();
        }
        return sum;
    }



}
