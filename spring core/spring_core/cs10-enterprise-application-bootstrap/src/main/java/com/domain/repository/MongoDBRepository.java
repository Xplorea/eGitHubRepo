package com.domain.repository;

import java.util.ArrayList;
import java.util.List;

import com.domain.model.Product;

public class MongoDBRepository implements ProductRepository {

	@Override
	public List<Product> getProducts() {
		System.out.println("MongoDBRepository");
		List<Product> products = new ArrayList<>();

		Product product = new Product();

		product.setProductId("P01");
		product.setProductName("Angular");

		products.add(product);

		return products;
	}

}
