package com.example.blogs.entities;

import com.example.blogs.dtos.PostDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;

    @Column(name = "post_name", length = 100, nullable = false)
    private String name;

    @Column(name = "post_content", length = 1000)
    private String content;

    private LocalDateTime createdOn;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public PostDto getPostDto() {
        PostDto postDto = new PostDto();
        postDto.setId(this.id);
        postDto.setName(this.name);
        postDto.setContent(this.content);
        postDto.setCreatedOn(this.createdOn);
        postDto.setCategoryId(this.category.getId());
        postDto.setCategoryName(this.category.getName());
        return postDto;
    }
}
