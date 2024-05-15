package com.example.blogs.entities;


import com.example.blogs.dtos.CategoryDto;
import com.example.blogs.dtos.PostDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name", length = 100, nullable = false)
    private String name;

    @Column(name = "category_description", length = 1000)
    private String description;

    private LocalDateTime createdOn;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    public CategoryDto getCategoryDto() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(this.id);
        categoryDto.setName(this.name);
        categoryDto.setDescription(this.description);
        categoryDto.setCreatedOn(this.createdOn);
        return categoryDto;
    }
}
