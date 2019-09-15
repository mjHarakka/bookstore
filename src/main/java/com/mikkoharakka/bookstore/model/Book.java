package com.mikkoharakka.bookstore.model;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends AbstractPersistable<Long> {
	
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;

}
