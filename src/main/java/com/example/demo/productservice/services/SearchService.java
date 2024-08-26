package com.example.demo.productservice.services;

import com.example.demo.productservice.models.Product;
import com.example.demo.productservice.repos.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private ProductRepo productRepo;

    public SearchService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    //PageRequest.of(pageNumber, pageSize))

    public List<Product> search(String keyword,int pageNumber,int pageSize) {
        return productRepo.findByTitleContains(keyword, PageRequest.of(pageNumber,pageSize));
    }
}
