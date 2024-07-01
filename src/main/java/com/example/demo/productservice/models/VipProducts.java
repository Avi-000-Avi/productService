package com.example.demo.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VipProducts extends BaseModel {

    @ManyToOne
    Category category1;
}
