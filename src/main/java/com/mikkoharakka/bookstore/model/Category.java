package com.mikkoharakka.bookstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractPersistable<Long> {
	
	private String name;
	@OneToMany(mappedBy = "category")
	private List<Book> books;
	

}
