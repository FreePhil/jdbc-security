package com.example.jdbcsecurity;

import com.example.jdbcsecurity.controller.HomeController;
import com.example.jdbcsecurity.model.Comment;
import com.example.jdbcsecurity.model.Post;
import com.example.jdbcsecurity.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JdbcSecurityApplicationTests {

    Logger logger = LoggerFactory.getLogger(JdbcSecurityApplicationTests.class);

    @Autowired
    private PostRepository posts;

    @Autowired
    private JdbcAggregateTemplate template;


    @Test
    void contextLoads() {
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testAddPost.csv")
    void testAddPost(String title, String content) {
        // arrange
        Post post = new Post(title, content, null);

        // act
        posts.save(post);

        // assert
        assertThat(post.getId()).isNotNegative();
        var newPost = posts.findById(post.getId()).orElseThrow();
        assertThat(newPost).isNotNull();
        assertThat(newPost.getTitle()).isEqualTo(title);
        assertThat(newPost.getContent()).isEqualTo(content);
        assertThat(newPost.getComments().size()).isEqualTo(0);

        // clean up
        template.delete(post);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testAddPostWithComments.csv")
    void testAddPostWithComments(String title, String content, String text) {
        // arrange
        Post post = new Post(title, content, null);
        String[] texts = text.split("\\|");
        for (int i = 0; i < texts.length; i += 2) {
            var comment = new Comment(texts[i], texts[i+1]);
            post.addComment(comment);
        }
        int count = texts.length / 2;

        // act
        posts.save(post);

        // assert
        var newPost = posts.findById(post.getId()).orElseThrow();
        assertThat(newPost.getTitle()).isEqualTo(title);
        assertThat(newPost.getContent()).isEqualTo(content);
        assertThat(newPost.getComments().size()).isEqualTo(count);

        // clean up
        template.delete(post);
    }

    @Test
    void testUpdateComment() {
        Post post = new Post("title01", "comment01", null);
        post.addComment(new Comment("commenter01", "comment-content01"));
        posts.save(post);

        var comment = post.getComments().stream().findFirst().orElseThrow();
        posts.updateComment(comment.getId(), "abc", comment.getContent());
        logger.info("saved: comment id {}", comment.getId());


        Post updatedPost = posts.findById(post.getId()).orElseThrow();
        var updateComment = updatedPost.getComments().stream().findFirst().orElseThrow();
        logger.info("after: comment id {}", updateComment.getId());
        assertThat(updateComment.getName()).isEqualTo("abc");
    }

}
