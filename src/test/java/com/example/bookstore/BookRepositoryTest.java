package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.domain.Book;
import com.example.bookstore.model.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;

	@Test
	public void findByAuthorShouldReturnTitle() {
		List<Book> books = repository.findByAuthor("Pekka Jalonen");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Taru kääpiöstä");

	}

	@Test
	public void createNewBook() {
		Book book = new Book("Hangover 4", "Jukka Palonen", 2016, "1239512-36", new Category(1, "Adventure"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteNewBook() {
		List<Book> books = repository.findByAuthor("Jukka Palonen");
		Book book = books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByAuthor("Jukka Palonen");
		assertThat(newBooks).hasSize(0);
	}
}
