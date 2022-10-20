package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.CategoryRepository;
import com.example.bookstore.model.UserRepository;
import com.example.bookstore.model.domain.Book;
import com.example.bookstore.model.domain.Category;
import com.example.bookstore.model.domain.User;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository urepository, BookRepository repository,
			CategoryRepository crepository) {
		return (args) -> {
			
			User user1 = new User("Aki", "$2a$12$yb1mbhmGVroL8wW33C4v1.qmVe427EnkfCz95jg7MeQO.yt7Jm/Aq",
					"User1@email.com", "USER");
			User user2 = new User("Pomo", "$2a$12$AILb1zHj32278haQdThvq.1khaFnKVnLajYwqkzt1KO0Ckga31P/6",
					"user2@email.com", "ADMIN");
			
			if(urepository.findByEmail(user1.getEmail()) == null) {
				urepository.save(user1);
			}
			if(urepository.findByEmail(user2.getEmail()) == null) {
				urepository.save(user2);
			}
			
			
			
			Category laji1 = new Category(1, "Adventure");
			Category laji2 = new Category(2, "Scifi");
			Category laji3 = new Category(3, "Horror");
			
			if (crepository.findByName(laji1.getName()) == null) {
				crepository.save(laji1);
			}
			
			if (crepository.findByName(laji2.getName()) == null) {
				crepository.save(laji2);
			}
			
			if (crepository.findByName(laji3.getName()) == null) {
				crepository.save(laji3);
			}
			

			Book first = new Book("Taru kääpiöstä", "Pekka Jalonen", 2017, "1234556-32", laji1);
			Book two = new Book("Elden Scrolls Ring", "Taimo Palola", 2019, "1294567-98", laji2);
			Book three = new Book("Hangover 4", "Jukka Palonen", 2016, "1239512-36", laji3);
			
			if (repository.findByAuthor(first.getAuthor())== null) {
				repository.save(first);
			}
			
			if (repository.findByAuthor(two.getAuthor())== null) {
				repository.save(two);
			}
			
			if (repository.findByAuthor(three.getAuthor())== null) {
				repository.save(three);
			}

		};
	}

}
