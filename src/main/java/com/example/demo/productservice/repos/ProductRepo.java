package com.example.demo.productservice.repos;


import com.example.demo.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


    Optional<Product> findById(Long id);

    void delete(Product product);

    @Override
    Product save(Product product); //  create and update

}
