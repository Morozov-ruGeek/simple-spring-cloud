package ru.geekbrains.front.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.spring.common.ProductDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final RestTemplate restTemplate;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        ProductDto[] productDtos = restTemplate.getForObject("http://product-service/api/v1/products", ProductDto[].class);
        List<ProductDto> products = List.of();
        if (productDtos != null) {
            products = Arrays.asList(productDtos);
        }
        return products;
    }

    @GetMapping("/{id}")
    public ProductDto getOneProduct(@PathVariable Long id) {
        return restTemplate.getForObject("http://product-service/api/v1/products/"+id, ProductDto.class);
    }
}
