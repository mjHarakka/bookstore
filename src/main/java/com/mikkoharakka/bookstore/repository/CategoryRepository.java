package com.mikkoharakka.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkoharakka.bookstore.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findAll();
}
