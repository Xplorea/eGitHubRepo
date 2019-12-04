#CREATE JAVA CONFIGURATION CLASS
package com.ezbuy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ezbuy.model.Product;

@Configuration
public class JavaConfig {

	@Bean(name = "product")
	public Product getProduct() {
		Product product = new Product(100, "Red",
				"Sun");
		return product;
	}
	
	@Bean(name = "defaultProduct")
	public Product getDefaultProduct() {
		Product product = new Product();
		return product;
	}
}


#CREATE APP TO USE THE BEANS
package com.ezbuy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ezbuy.config.JavaConfig;
import com.ezbuy.model.Product;

public class App {
	public static void main(String[] args) {
		System.out.println("Welcome to eZBuy");
		AbstractApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		Product product = (Product) applicationContext.getBean("product");
		System.out.println(product);
		product.setProductName("GreenMoon");
		System.out.println(product);
		System.out.println((applicationContext.getBean("defaultProduct")));
	}
}
