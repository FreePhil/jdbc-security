package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
