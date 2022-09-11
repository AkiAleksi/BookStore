package com.example.bookstore.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstore.model.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping(value = "/booklist")
	public String Book(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

}
