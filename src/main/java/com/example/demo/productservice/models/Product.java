package com.example.demo.productservice.models;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private String description;
    private int quantity;
    private boolean isDeleted = false;
}

