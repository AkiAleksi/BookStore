package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.model.UserRepository;
import com.example.bookstore.model.domain.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	@Test
	public void createNewUser() {
		User user = new User("Moi", "Koira", "koi@mail.com", "USER");
		repository.save(user);
		assertThat(user.getUsername()).isNotNull();

	}

	@Test
	public void findByAuthorShouldReturnTitle() {
		User users = repository.findByUsername("Aki");
		assertThat(users.getEmail()).isEqualTo("User1@email.com");
	}

	@Test
	public void deleteNewBook() {
		List<User> users = repository.findByEmail("User1@email.com");
		User user = users.get(0);
		repository.delete(user);
		List<User> newUsers = repository.findByEmail("User1@email.com");
		assertThat(newUsers).hasSize(0);
	}

}
