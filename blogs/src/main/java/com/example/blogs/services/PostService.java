package com.example.blogs.services;

import com.example.blogs.dtos.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto updatePost(Integer postId,PostDto postDto);
    PostDto getById(Integer postId);
    List<PostDto> getAllPosts();
    String deletePost(Integer postId);
    List<PostDto> getAllPostsByCategoryId(Integer categoryId);
}
