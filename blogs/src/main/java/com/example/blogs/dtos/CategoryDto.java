package com.example.blogs.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private int id;

    @NotEmpty
    @Size(min = 3, max = 15, message = "Category name cannot be empty and should be min 3 and max 15 characters.")
    private String name;
    private String description;
    private LocalDateTime createdOn;
}
