package com.app.services;

import java.util.List;

import com.app.dto.ProductReqDto;
import com.app.dto.ProductRespDto;
import com.app.exception.ProductException;
import com.app.pojos.Category;
import com.app.pojos.Product;

public interface ProductServices {
	
	Product addProduct(ProductReqDto newProduct);
	List<Product> getProductByName(String name) throws ProductException;
	List<Product> getProducts();
	Product deleteProduct(int id) throws ProductException;
	List<Product> getProductsByType(Category type) throws ProductException;
}
