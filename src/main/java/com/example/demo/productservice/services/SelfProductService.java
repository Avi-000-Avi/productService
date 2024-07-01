package com.example.demo.productservice.services;

import com.example.demo.productservice.models.Category;
import com.example.demo.productservice.models.Product;
import com.example.demo.productservice.repos.CategoryRepo;
import com.example.demo.productservice.repos.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements  ProductServices{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Product getProductById(Long Id) {
        Optional<Product> product = productRepo.findById(Id);
        if(product.isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            Category savedCategory = categoryRepo.save(category);
            product.setCategory(savedCategory);
        }

        //Another way categoryRepo.findByTitle(product.getCategory().getId())

        product.setCreatedAt("15th June");
        Product savedProduct = productRepo.save(product);
        return savedProduct;
    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long Id) {

    }
}
