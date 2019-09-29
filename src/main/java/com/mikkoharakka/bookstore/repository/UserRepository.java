package com.mikkoharakka.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkoharakka.bookstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
