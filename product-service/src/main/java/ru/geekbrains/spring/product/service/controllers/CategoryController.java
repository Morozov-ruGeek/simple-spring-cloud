package ru.geekbrains.spring.product.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.spring.common.CategoryDto;
import ru.geekbrains.spring.product.service.error_handling.ResourceNotFoundException;
import ru.geekbrains.spring.product.service.models.Category;
import ru.geekbrains.spring.product.service.services.CategoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto findOneById(@PathVariable Long id) {
        Category category = categoryService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Категория с id="+id+" не найдена"));
        return CategoryService.functionCategoryToDto.apply(category);
    }

}
