package com.example.blogs.services.impl;

import com.example.blogs.dtos.PostDto;
import com.example.blogs.dtos.PostRequestDto;
import com.example.blogs.entities.Category;
import com.example.blogs.entities.Post;
import com.example.blogs.exceptions.ResourceNotFoundException;
import com.example.blogs.repository.CategoryRepository;
import com.example.blogs.repository.PostRepository;
import com.example.blogs.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public PostDto createPost(PostRequestDto postDto) {

        Post post = new Post();
        post.setName(postDto.getPostName());
        post.setContent(postDto.getContent());
        post.setCreatedOn(LocalDateTime.now());
        Category category = this.categoryRepository.findById(postDto.getCategoryId()).orElseThrow(
                () -> new ResourceNotFoundException("Category","categoryId",postDto.getCategoryId())
        );
        post.setCategory(category);
        return this.postRepository.save(post).getPostDto();
    }

    @Override
    public PostDto updatePost(Integer postId,PostRequestDto postDto) {
        Post post = this.postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post","postId",postId)
        );
        post.setName(postDto.getPostName());
        post.setContent(postDto.getContent());
        Category category = this.categoryRepository.findById(postDto.getCategoryId()).orElseThrow(
                ()-> new ResourceNotFoundException("Category","categoryId",postDto.getCategoryId())
        );
        post.setCategory(category);
        return this.postRepository.save(post).getPostDto();
    }

    @Override
    public PostDto getById(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post","postId",postId)
        );
        return post.getPostDto();
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();
        return posts.stream().map(Post::getPostDto).collect(Collectors.toList());
    }

    @Override
    public String deletePost(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post","postId",postId)
        );
        this.postRepository.delete(post);
        return "Deleted Successfully";
    }

    public List<PostDto> getAllPostsByCategoryId(Integer categoryId)
    {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(
                ()-> new ResourceNotFoundException("Category","categoryId",categoryId)
        );
        List<Post> posts = this.postRepository.findByCategory(category);
        return posts.stream().map(Post::getPostDto).collect(Collectors.toList());
    }
}
