package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Category;
import com.app.pojos.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	Optional<List<Product>> findByName(String name);
	Optional<List<Product>> findByType(Category type);
}
