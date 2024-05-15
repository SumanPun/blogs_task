package com.example.blogs.services;

import com.example.blogs.dtos.PostDto;
import com.example.blogs.dtos.PostRequestDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostRequestDto postDto);
    PostDto updatePost(Integer postId,PostRequestDto postDto);
    PostDto getById(Integer postId);
    List<PostDto> getAllPosts();
    String deletePost(Integer postId);
    List<PostDto> getAllPostsByCategoryId(Integer categoryId);
}
