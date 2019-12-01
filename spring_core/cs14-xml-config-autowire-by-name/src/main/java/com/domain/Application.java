package com.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.service.ProductService;

public class Application {
	public static void main(String[] args) {
		System.out.println("cs14-xml-config-autowire-by-name");
		// Removing the hard-coded instance.
		// ProductService productService = new ProductServiceImpl();
		ProductService productService;

		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// The second parameter reduces the burden of type casting.
		productService = appContext.getBean("productService",
				ProductService.class);
		// java 8 forEach lambda expressions
		//productService.getProducts().forEach(System.out::println);
		productService.getProducts().forEach(product -> System.out.println(
				product.getProductId() + " : " + product.getProductName()));
	}
}
