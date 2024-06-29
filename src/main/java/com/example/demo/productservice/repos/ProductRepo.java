package com.example.demo.productservice.repos;


import com.example.demo.productservice.models.Product;
import com.example.demo.productservice.projections.ProductwithTitleandDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


    Optional<Product> findById(Long id);

    void delete(Product product);

    @Override
    Product save(Product product); //  create and update

    //HQL
    @Query("select p.title,p.description from Product  p where p.id=:id")
    ProductwithTitleandDesc someRandomQuery(@Param("id") Long id);

    //SQL
    @Query(value = "select title,description from product where id = :id",nativeQuery = true)
    ProductwithTitleandDesc someRandomQuery(@Param("id") Long id);
}
