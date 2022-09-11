package com.example.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.model.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByAuthor(String author);
}
