package com.example.bookstore.model;

import com.example.bookstore.model.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}