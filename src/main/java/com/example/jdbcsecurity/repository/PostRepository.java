package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.Comment;
import com.example.jdbcsecurity.model.Post;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends CrudRepository<Post, Integer> {

    @Modifying
    @Query("update comment set name = :name, content = :content where id = :id ")
    boolean updateComment(@Param("id") Integer commentId, @Param("name") String name, @Param("content") String content);
}
