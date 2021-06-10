package ru.geekbrains.spring.product.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.spring.common.ProductDto;
import ru.geekbrains.spring.product.service.error_handling.ResourceNotFoundException;
import ru.geekbrains.spring.product.service.models.Product;
import ru.geekbrains.spring.product.service.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        List<Product> products = productService.findAll();
        return products.stream().map(ProductService.functionProductToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto getOneProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        Product product = productOptional.orElseThrow(() -> new ResourceNotFoundException("Продукт не найден, id: "+id));
        return ProductService.functionProductToDto.apply(product);
    }

}
