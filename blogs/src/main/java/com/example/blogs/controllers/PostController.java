package com.example.blogs.controllers;

import com.example.blogs.dtos.PostDto;
import com.example.blogs.dtos.PostRequestDto;
import com.example.blogs.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostRequestDto postDto)
    {
        PostDto addPost = this.postService.createPost(postDto);
        return new ResponseEntity<>(addPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts()
    {
        List<PostDto> posts = this.postService.getAllPosts();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
    {
        PostDto postDto = this.postService.getById(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Integer postId, @RequestBody PostRequestDto postDto)
    {
        PostDto updatePost = this.postService.updatePost(postId,postDto);
        return new ResponseEntity<>(updatePost,HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId)
    {
        String result = this.postService.deletePost(postId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable Integer categoryId)
    {
        List<PostDto> allPosts = this.postService.getAllPostsByCategoryId(categoryId);
        return new ResponseEntity<>(allPosts,HttpStatus.OK);
    }
}
