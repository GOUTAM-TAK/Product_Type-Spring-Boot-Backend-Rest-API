package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductReqDto;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.services.ProductServices;

@RestController
@RequestMapping(path = "/products")

public class ProductController {
	@Autowired
	private  ProductServices ps;
	
	@PostMapping
	public ResponseEntity<?> insertProduct(@RequestBody @Valid ProductReqDto newProduct)
	{		
		Product pd=null;
		try {
			pd=ps.addProduct(newProduct);
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
		}
		return ResponseEntity.status(202).body(pd);
	}
	
	@GetMapping
	public ResponseEntity<?> getProducts()
	{		
		List<Product>list=null;
		try {
			list=ps.getProducts();
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
		}
		return ResponseEntity.status(202).body(list);
	}
	@GetMapping("/{type}")
	public ResponseEntity<?> getProductsByType(@PathVariable String type)
	{		
		List<Product>list=null;
		try {
			Category c=Category.valueOf(type.toUpperCase());
			list=ps.getProductsByType(c);
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
		}
		return ResponseEntity.status(200).body(list);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id)
	{		
		Product p=null;
		try {
			
			p=ps.deleteProduct(id);
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
		}
		return ResponseEntity.status(200).body(p);
	}
	@GetMapping("/product_name/{name}")
	public ResponseEntity<?> getProductByName(@PathVariable String name)
	{		
		List<Product> p=null;
		try {
			
			p=ps.getProductByName(name);
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
		}
		return ResponseEntity.status(200).body(p);
	}
}
