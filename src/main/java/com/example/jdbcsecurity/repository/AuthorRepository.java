package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
