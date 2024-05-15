package com.example.blogs.services;

import com.example.blogs.dtos.CategoryDto;
import com.example.blogs.dtos.PostDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto);
    CategoryDto getById(Integer categoryId);
    List<CategoryDto> getAllCategories();
    String deleteById(Integer categoryId);

}
