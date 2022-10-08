package com.example.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.model.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByName(String name);
}