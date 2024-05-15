package com.example.blogs.controllers;

import com.example.blogs.dtos.CategoryDto;
import com.example.blogs.dtos.PostDto;
import com.example.blogs.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto)
    {
        CategoryDto addCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(addCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory()
    {
        List<CategoryDto> categories = this.categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId)
    {
        CategoryDto category = this.categoryService.getById(categoryId);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Integer categoryId, @RequestBody CategoryDto categoryDto)
    {
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryId,categoryDto);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer categoryId)
    {
        String result = this.categoryService.deleteById(categoryId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}
