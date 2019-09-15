package com.mikkoharakka.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mikkoharakka.bookstore.repository.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/listbooks/{id}")
	public String deleteBook(@PathVariable long id) {
		bookRepository.deleteById(id);
		
		return "redirect:/listbooks";
	}
	
	@GetMapping("/listbooks")
	public String listBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "booklist";
	}
	
}
