package com.example.jdbcsecurity;

import com.example.jdbcsecurity.model.Author;
import com.example.jdbcsecurity.model.Comment;
import com.example.jdbcsecurity.model.Post;
import com.example.jdbcsecurity.repository.AuthorRepository;
import com.example.jdbcsecurity.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;


@SpringBootApplication
public class JdbcSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository posts, AuthorRepository authors) {
        return args -> {
//            AggregateReference<Author, Integer> dan = AggregateReference.to(authors.save(new Author(null, "Dan", "Vega", "dan.vega@gmail.com", "dvega")).id());
//
//            Post post = new Post("Hello World", "Welcom to my blog", dan);
//            post.addComment(new Comment("Dan", "This is my first comment"));
//            posts.save(post);
        };
    }
}
