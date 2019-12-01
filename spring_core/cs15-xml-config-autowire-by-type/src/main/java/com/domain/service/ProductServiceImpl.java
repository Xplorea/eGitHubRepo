package com.domain.service;

import java.util.List;

import com.domain.model.Product;
import com.domain.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {
	// Removing the hard-coded instance.
//private ProductRepository productRepository = new MongoDBRepository();
	private ProductRepository productRepository;
	
	public ProductServiceImpl() {
	}


	public ProductServiceImpl(ProductRepository productRepository) {
		//super();
		System.out.println("Constructor Injection : ProductServiceImpl(ProductRepository productRepository)");
		this.productRepository = productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		System.out.println("Setter Injection : setProductRepository(ProductRepository productRepository)");
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
}
