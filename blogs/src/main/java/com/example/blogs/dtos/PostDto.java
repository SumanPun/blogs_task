package com.example.blogs.dtos;

import com.example.blogs.entities.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private int id;
    @NotEmpty
    @Size(min=3, max = 20, message = "Name cannot be null and should be min 3 and max 20 character")
    private String name;

    private String content;
    private LocalDateTime createdOn;

    @NotEmpty(message = "categoryId cannot be null")
    private Integer categoryId;
    private String categoryName;
}
