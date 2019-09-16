package com.mikkoharakka.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mikkoharakka.bookstore.model.Book;
import com.mikkoharakka.bookstore.repository.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/addbook")
	public String addBook() {
		return "addbook";
	}
	
	@PostMapping("/addbook")
    public String assignAirport(@RequestParam String author,
    		@RequestParam String title,
    		@RequestParam int year,
    		@RequestParam String isbn,
    		@RequestParam double price) {
    
	Book b = new Book();
	b.setAuthor(author);
	b.setIsbn(isbn);
	b.setTitle(title);
	b.setPrice(price);
	b.setYear(year);
    
	bookRepository.save(b);
    
    return "redirect:/addbook/";
}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable long id, Model model) {
		model.addAttribute("book", bookRepository.getOne(id));
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable long id,
			@RequestParam String author,
    		@RequestParam String title,
    		@RequestParam int year,
    		@RequestParam String isbn,
    		@RequestParam double price) {
		
		Book b = bookRepository.getOne(id);
		
		b.setAuthor(author);
		b.setIsbn(isbn);
		b.setTitle(title);
		b.setPrice(price);
		b.setYear(year);
		
		bookRepository.deleteById(id);
		bookRepository.save(b);
		
		return "redirect:/";
	}
	
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
