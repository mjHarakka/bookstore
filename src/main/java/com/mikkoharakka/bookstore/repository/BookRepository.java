package com.mikkoharakka.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkoharakka.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findAll();
}
