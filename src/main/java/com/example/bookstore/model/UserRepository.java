package com.example.bookstore.model;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.model.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
