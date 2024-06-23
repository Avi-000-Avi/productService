package com.example.demo.productservice.repos;

import com.example.demo.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
