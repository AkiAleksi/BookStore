package com.example.bookstore.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class BookController {
	@RequestMapping("/index")
	public String indexMsg() {
		return "moi!!";
	}

}
