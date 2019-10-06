package com.mikkoharakka.bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mikkoharakka.bookstore.model.Book;
import com.mikkoharakka.bookstore.model.Category;
import com.mikkoharakka.bookstore.model.User;
import com.mikkoharakka.bookstore.repository.BookRepository;
import com.mikkoharakka.bookstore.repository.CategoryRepository;
import com.mikkoharakka.bookstore.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Test
    public void createNewBook() {
    	Book book = new Book("title", "author", 2012, "ISBN", 20.20, new Category("Test", null));
    	bookRepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
	
	@Test
    public void createNewCategory() {
    	Category category = new Category("Test Category", null);
    	categoryRepository.save(category);
    	assertThat(category).isNotNull();
    } 
	
	@Test
    public void createNewUser() {
    	User user = new User(999l, "Test", "Test", "USER");
    	userRepository.save(user);
    	assertThat(user.getId()).isNotNull();
    } 
	


}

	

	

