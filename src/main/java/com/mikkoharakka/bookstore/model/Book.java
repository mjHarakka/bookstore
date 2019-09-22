package com.mikkoharakka.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Book extends AbstractPersistable<Long> {
	
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	@JsonIgnore
	@ManyToOne
	private Category category;

}
