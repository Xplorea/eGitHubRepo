# cs10-enterprise-application-bootstrap

SET UP MAVEN CONSOLE APP
create a simple project (skip archetype selection)
group id : com.domain
artifact id : cs10-enterprise-app-bootstrap

CONFIGURE MAVEN COMPILER TO USE JAVA 8.
<build>
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>3.2</version>
<configuration>
<source>1.8</source>
<target>1.8</target>
</configuration>
</plugin>
</plugins>
</build>

CONFIGURE SPRING DEPENDENCIES
<dependencies>
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-context</artifactId>
<version>4.3.2.RELEASE</version>
</dependency>
</dependencies>

# cs11-xml-config-setter-injection
## pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.domain</groupId>
  <artifactId>cs11-xml-config-setter-injection</artifactId>
  <version>0.0.1-SNAPSHOT</version>
    <dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.3.2.RELEASE</version>
		</dependency>
	</dependencies>
  <build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.2</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
</build>
</project>

## Application

package com.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.service.ProductService;

public class Application {
public static void main(String[] args) {
System.out.println("cs11-xml-config-setter-injection");
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

## model

package com.domain.model;

public class Product {
private String productId;
private String productName;

    public Product() {
    }

    public String getProductId() {
    	return productId;
    }

    public String getProductName() {
    	return productName;
    }

    public void setProductId(String productId) {
    	this.productId = productId;
    }

    public void setProductName(String productName) {
    	this.productName = productName;
    }

    @Override
    public String toString() {
    	return "Product [productId=" + productId + ", productName=" + productName + "]";
    }

}

## repository

package com.domain.repository;

import java.util.List;

import com.domain.model.Product;

public interface ProductRepository {
List<Product> getProducts();
}

package com.domain.repository;

import java.util.ArrayList;
import java.util.List;

import com.domain.model.Product;

public class MongoDBRepository implements ProductRepository {

    @Override
    public List<Product> getProducts() {
    	//System.out.println("MongoDBRepository.getProducts()");
    	List<Product> products = new ArrayList<>();

    	Product product = new Product();

    	product.setProductId("P01");
    	product.setProductName("Angular");

    	products.add(product);

    	return products;
    }

}

package com.domain.repository;

import java.awt.List;

import com.domain.model.Product;

public class PostgreSQLRepository implements ProductRepository{

    @Override
    public java.util.List<Product> getProducts() {
    	return null;
    }

}

## service 
package com.domain.service;

import java.util.List;

import com.domain.model.Product;

public interface ProductService {
	List<Product> getProducts();
}

package com.domain.service;

import java.util.List;

import com.domain.model.Product;
import com.domain.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {
	// Removing the hard-coded instance.
//private ProductRepository productRepository = new MongoDBRepository();
	private ProductRepository productRepository;

	public void setProductRepository(ProductRepository productRepository) {
		System.out.println("Setter Injection : setProductRepository(ProductRepository productRepository)");
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
}

## configuration /cs11-xml-config-setter-injection/src/main/resources/applicationContext.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


 <bean name="productRepository"
		class="com.domain.repository.MongoDBRepository" /> 

	<bean name="productService"
		class="com.domain.service.ProductServiceImpl">
			<!-- setter injection -->
		<!-- <property name="productRepository" ref="productRepository"></property> -->
	</bean>
</beans>
