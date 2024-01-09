package com.devsuperior.dscommerce.dto;


import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private long id;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3,max = 80,message = "O nome precisa ter de 3 a 80 caracteres")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Size(min = 10,message = "O descrição precisa ter no minimo 10 caracteres")
    private String description;
    @Positive(message = "O preço precisa ser positivo")
    private double price;
    private String imgUrl;

    public ProductDTO (){

    }

    public ProductDTO(long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }

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
}
