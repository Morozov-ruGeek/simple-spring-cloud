package ru.geekbrains.front.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.spring.common.CategoryDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final RestTemplate restTemplate;

    @GetMapping("/{id}")
    public CategoryDto findOneById(@PathVariable Long id) {
        return restTemplate.getForObject("http://product-service/api/v1/category/"+id, CategoryDto.class);
    }
}
