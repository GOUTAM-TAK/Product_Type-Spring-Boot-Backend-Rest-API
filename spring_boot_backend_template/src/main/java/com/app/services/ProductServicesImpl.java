package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductDao;
import com.app.dto.ProductReqDto;
import com.app.exception.ProductException;
import com.app.pojos.Category;
import com.app.pojos.Product;
@Service
@Transactional
public class ProductServicesImpl implements ProductServices {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ProductDao pd;

	@Override
	public Product addProduct(ProductReqDto newProduct) {
		// TODO Auto-generated method stub
	Product product=mapper.map(newProduct, Product.class);
	product.setType(Category.valueOf(newProduct.getType().toUpperCase()));
	pd.save(product);
		return product;
	}

	@Override
	public List<Product> getProductByName(String name) throws ProductException {
		// TODO Auto-generated method stub
		
		return pd.findByName(name).orElseThrow(()->new ProductException("Product not found!!"));
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return pd.findAll();
			}

	@Override
	public Product deleteProduct(int id) throws ProductException {
		// TODO Auto-generated method stub
		Product temp=pd.findById(id).orElseThrow(()->new ProductException("Product not found!!"));
		pd.deleteById(id);
		return temp;
	}

	@Override
	public List<Product> getProductsByType(Category type) throws ProductException {
		// TODO Auto-generated method stub
		
		return pd.findByType(type).orElseThrow(()->new ProductException("Product not found!!"));
	}

}
