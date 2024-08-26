package com.example.demo.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {
    String keyword;
    int pageNumber;
    int sizeOfPage;
}
