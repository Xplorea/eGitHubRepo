package com.domain.service;

import java.util.List;

import com.domain.model.Product;
import com.domain.repository.MongoDBRepository;
import com.domain.repository.ProductRepository;

public class ProductServiceImpl implements ProductService  {
private ProductRepository productRepository = new MongoDBRepository();
	//@Override
	/* (non-Javadoc)
	 * @see com.domain.service.ProductService#getProducts()
	 */
	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
	
	
	public List<Product> getProducts1() {
		return productRepository.getProducts();
	}
}
