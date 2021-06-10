package ru.geekbrains.spring.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDto {
    private Long id;
    private String title;
}
