package com.mikkoharakka.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mikkoharakka.bookstore.model.Book;
import com.mikkoharakka.bookstore.repository.BookRepository;
import com.mikkoharakka.bookstore.repository.CategoryRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/")
	public String getRoot() {
		return "redirect:/listbooks/";
	}
	
	@GetMapping("/addbook")
	public String getAddBook(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@PostMapping("/addbook")
    public String postAddBook(@RequestParam String author,
    		@RequestParam String title,
    		@RequestParam int year,
    		@RequestParam String isbn,
    		@RequestParam double price,
    		@RequestParam long categoryId) {
    
	Book b = new Book();
	b.setAuthor(author);
	b.setIsbn(isbn);
	b.setTitle(title);
	b.setPrice(price);
	b.setYear(year);
	b.setCategory(categoryRepository.getOne(categoryId));
    
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
		
		return "redirect:/listbooks";
	}
	
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long id, Model
	model) { bookRepository.deleteById(id); return "redirect:../listbooks";
	}
	
	/*
	@GetMapping("/listbooks/{id}")
	public String deleteBook(@PathVariable long id) {
		bookRepository.deleteById(id);
		
		
	}
	*/
	 
	@GetMapping("/listbooks")
	public String listBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "booklist";
	}
	
}
