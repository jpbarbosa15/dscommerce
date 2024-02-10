package com.devsuperior.dscommerce.dto;


import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @NotEmpty(message = "Deve ter pelo meno 1 categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

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
        for(Category cat : product.getCategories()){
            categories.add(new CategoryDTO(cat));
        }
    }

    public long getId() {
        return id;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
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
