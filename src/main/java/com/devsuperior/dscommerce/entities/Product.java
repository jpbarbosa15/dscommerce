package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private double price;
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
    @OneToMany(mappedBy = "id.product")
    private Set <OrderItem> items = new HashSet<>();




    public Product(long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Product(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<OrderItem> getItems() {
        return items;
    }
    //alternativa para o getItems
    public List<Order> getOrders() {
        return items.stream().map(x -> x.getOrder()).toList();
    }

}
