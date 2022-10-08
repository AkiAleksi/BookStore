package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.model.CategoryRepository;
import com.example.bookstore.model.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository repository;

	@Test
	public void createNewCategory() {
		Category cate = new Category(1, "SCIFI");
		repository.save(cate);
		assertThat(cate.getName()).isNotNull();

	}

	@Test
	public void findByAuthorShouldReturnTitle() {
		List<Category> category = repository.findByName("Adventure");
		assertThat(category).hasSize(1);
		assertThat(category.get(0).getId()).isEqualTo(1);
	}

	@Test
	public void deleteNewCategory() {
		List<Category> categories = repository.findByName("Adventure");
		Category category = categories.get(0);
		repository.delete(category);
		List<Category> newCategories = repository.findByName("Adventure");
		assertThat(newCategories).hasSize(0);
	}

}
