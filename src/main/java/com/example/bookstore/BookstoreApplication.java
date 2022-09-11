package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {

			Book first = new Book("Taru kääpiöstä", "Pekka Jalonen", 2017, 12345);
			Book two = new Book("Elden Scrolls Ring", "Taimo Palola", 2019, 12945);
			Book three = new Book("Hartikainen", "Jukka Palonen", 2016, 12395);

			repository.save(first);
			repository.save(two);
			repository.save(three);

		};
	}

}
