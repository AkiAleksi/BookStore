package com.example.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.model.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

	List<User> findByEmail(String email);
}
