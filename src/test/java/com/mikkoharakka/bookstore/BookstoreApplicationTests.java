package com.mikkoharakka.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mikkoharakka.bookstore.controller.BookController;
import com.mikkoharakka.bookstore.repository.BookRepository;
import com.mikkoharakka.bookstore.repository.CategoryRepository;
import com.mikkoharakka.bookstore.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired
	private BookController controller;
	
	@Test
	public void contexLoads() throws Exception {
	    assertThat(controller).isNotNull();
	}	

}
