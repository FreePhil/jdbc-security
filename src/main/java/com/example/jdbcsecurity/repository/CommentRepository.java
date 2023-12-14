package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
