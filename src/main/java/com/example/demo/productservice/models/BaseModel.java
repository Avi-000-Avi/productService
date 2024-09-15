package com.example.demo.productservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /// Auto Increment
    private Long  id;
    private String createdAt;
}
