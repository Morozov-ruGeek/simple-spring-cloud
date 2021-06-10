package ru.geekbrains.spring.product.service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.common.CategoryDto;
import ru.geekbrains.spring.product.service.models.Category;
import ru.geekbrains.spring.product.service.repositories.CategoryRepository;


import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public static final Function<Category, CategoryDto> functionCategoryToDto = c -> {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(c.getId());
        categoryDto.setTitle(c.getTitle());
        return categoryDto;
    };

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

}
