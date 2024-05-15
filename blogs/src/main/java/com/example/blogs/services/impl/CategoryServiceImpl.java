package com.example.blogs.services.impl;

import com.example.blogs.dtos.CategoryDto;
import com.example.blogs.dtos.PostDto;
import com.example.blogs.entities.Category;
import com.example.blogs.entities.Post;
import com.example.blogs.exceptions.ResourceNotFoundException;
import com.example.blogs.repository.CategoryRepository;
import com.example.blogs.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setCreatedOn(LocalDateTime.now());
        category.setDescription(categoryDto.getDescription());
        return this.categoryRepository.save(category).getCategoryDto();
    }

    @Override
    public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(
                ()-> new ResourceNotFoundException("Category","categoryId",categoryId)
        );
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return this.categoryRepository.save(category).getCategoryDto();
    }

    @Override
    public CategoryDto getById(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(
                ()-> new ResourceNotFoundException("Category","categoryId",categoryId)
        );
        return category.getCategoryDto();
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        return categories.stream().map(Category::getCategoryDto).collect(Collectors.toList());
    }

    @Override
    public String deleteById(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(
                ()-> new ResourceNotFoundException("Category","categoryId",categoryId)
        );
        this.categoryRepository.delete(category);
        return "Deleted Successfully";
    }

//    @Override
//    public List<PostDto> getAllPostsByCategory(Integer categoryId)
//    {
//        List<Post> posts = this.categoryRepository.getAllPostsByCategory(categoryId);
//        return posts.stream().map(Post::getPostDto).collect(Collectors.toList());
//    }

}
