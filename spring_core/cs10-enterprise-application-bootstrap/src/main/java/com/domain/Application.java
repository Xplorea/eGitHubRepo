package com.domain;

import com.domain.service.ProductService;
import com.domain.service.ProductServiceImpl;

public class Application {
	public static void main(String[] args) {
		ProductService productService = new ProductServiceImpl();
		//java 8 forEach lambda expressions
		productService.getProducts().forEach(System.out::println);
//		productService.getProducts().forEach(product -> System.out.println(
//				product.getProductId() + " : " + product.getProductName()));
	}
}
