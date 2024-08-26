package com.example.demo.productservice.controllers;

import com.example.demo.productservice.dtos.SearchRequestDto;
import com.example.demo.productservice.models.Product;
import com.example.demo.productservice.services.SearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @PostMapping
    public List<Product> search(@RequestBody SearchRequestDto searchRequestDto) {
        return searchService.search(searchRequestDto.getKeyword(), searchRequestDto.getPageNumber(), searchRequestDto.getSizeOfPage());
    }

}
