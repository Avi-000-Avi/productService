package com.example.demo.productservice.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_ta")
public class TA extends User {
    private int numberOfSession;

    private float avgRating;
}

