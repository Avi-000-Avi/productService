package com.example.demo.productservice.services;

import com.example.demo.productservice.dtos.FakeStoreProductDto;
import com.example.demo.productservice.models.Category;
import com.example.demo.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeProductService")
public class FakeProductService implements ProductServices{

    //One way to call product service
    //RestTemplate is a dependency by a constructor injection
    private RestTemplate restTemplate;

    public FakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long Id) {
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + Id, FakeStoreProductDto.class);
//        return convertDtoToProduct(fakeStoreProductDto);
        throw new RuntimeException();
    }

    @Override
    public List<Product> getAllProducts() {
        //Get products from 3rd party
        FakeStoreProductDto[] fakeStoreProductDtoList =
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
                List<Product> products = new ArrayList<>();

                //Convert Result
                for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList){
                    products.add(convertDtoToProduct(fakeStoreProductDto));
                }
                return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id,Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertProductToDto(product);
        fakeStoreProductDto =  restTemplate.patchForObject("https://fakestoreapi.com/products/" + id,
                fakeStoreProductDto, FakeStoreProductDto.class);
        return convertDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public void deleteProduct(Long Id) {
    }

    private Product convertDtoToProduct(FakeStoreProductDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        // Assuming Category can be created with just the title from the DTO
        Category category = new Category();
        category.setId(0L);
        category.setTitle(dto.getCategory());
        product.setCategory(category);

        return product;
    }

    public static FakeStoreProductDto convertProductToDto(Product product) {
        if (product == null) {
            return null;
        }

        FakeStoreProductDto dto = new FakeStoreProductDto();

        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());

        // Assuming the category title is what needs to be set in the DTO's category field
        if (product.getCategory() != null) {
            dto.setCategory(product.getCategory().getTitle());
        } else {
            dto.setCategory(null); // or set to a default value as appropriate
        }

        return dto;
    }
}
