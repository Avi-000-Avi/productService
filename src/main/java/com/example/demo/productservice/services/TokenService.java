package com.example.demo.productservice.services;

import com.example.demo.productservice.dtos.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TokenService {
    private RestTemplate restTemplate;

    public TokenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validateToken(String token) {
        System.out.println(token + "token");
        UserDto userDto = restTemplate.postForObject("http://localhost:9800/users/validate/" +  token, null, UserDto.class);

        System.out.println(userDto + "userDto");
        return userDto != null;
    }
}