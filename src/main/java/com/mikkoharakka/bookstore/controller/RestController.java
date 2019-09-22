package com.mikkoharakka.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mikkoharakka.bookstore.model.Book;
import com.mikkoharakka.bookstore.repository.BookRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	 private BookRepository bookRepository;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		List<Book> books = bookRepository.findAll();
	    return books;
	}
	
	@GetMapping("/books/{id}")
	public Optional<Book> getBook(@PathVariable Long id) {
	    return bookRepository.findById(id);
	}
	
	@DeleteMapping("/books/{id}")
	public Book deleteBook(@PathVariable Long id) {
		Book b = bookRepository.getOne(id);
	        
	    bookRepository.delete(b);
	    
	    return b;
	}
	
	@PostMapping("/books")
	public Book postBook(@RequestBody Book book) {
	    return bookRepository.save(book);
	}
	
}
