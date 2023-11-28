package com.example.jdbcsecurity.controller;

import com.example.jdbcsecurity.model.Post;
import com.example.jdbcsecurity.model.PostDetail;
import com.example.jdbcsecurity.repository.AuthorRepository;
import com.example.jdbcsecurity.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository posts;
    private final AuthorRepository authors;

    public PostController(PostRepository posts, AuthorRepository authors) {
        this.posts = posts;
        this.authors = authors;
    }

    @GetMapping
    public Iterable<Post> findAll() {
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id) {
        return posts.findById(id).orElse(null);
    }

    @GetMapping("/{id}/detail")
    public PostDetail findDetailById(@PathVariable Integer id) {
        Post post = posts.findById(id).orElse(null);
        return new PostDetail(post, authors.findById(post.getAuthor().getId()).orElse(null));
    }
}
