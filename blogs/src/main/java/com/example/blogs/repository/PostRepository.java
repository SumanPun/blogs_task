package com.example.blogs.repository;

import com.example.blogs.entities.Category;
import com.example.blogs.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByCategory(Category category);
}
