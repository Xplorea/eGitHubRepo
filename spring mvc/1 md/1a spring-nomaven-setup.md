#CREATE A STANDALONE SPRING APP WITHOUT MAVEN

<create New Java Project

[App]
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to eZBuy" );
    }
}

#CONFIGURE SPRING DEPENDENCIES
[download]
https://repo.spring.io/release/org/springframework/spring/5.1.5.RELEASE/
spring-framework-5.1.5.RELEASE-dist.zip
<create lib-spring folder inside the root of your project>
<copy all jar file from libs inside the spring-framework-5.1.5.RELEASE-dist folder>
<configure build path - add all jars from lib-spring folder.

#create new spring bean configuration inside src folder 
[spring-config.xml]
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean id="product" class="com.ezbuy.model.Product">
		<constructor-arg name="productID" value="100" />
		<constructor-arg name="productName" value="Red" />
		<constructor-arg name="description" value="Sun" />
	</bean>
    <bean id="defaultProduct" class="com.ezbuy.model.Product">
	</bean>
</beans>

#CREATE APP TO USE THE BEANS
package com.ezbuy;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ezbuy.model.Product;

public class App {
	public static void main(String[] args) {
		System.out.println("Welcome to eZBuy");
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring-config.xml");
//		AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext(
//				"C:\\users\\subbu\\desktop\\spring-config.xml");
		Product product = (Product) applicationContext.getBean("product");
		System.out.println(product);
		product.setProductName("GreenMoon");
		System.out.println(product);
		System.out.println((applicationContext.getBean("defaultProduct")));
	}
}

[run]


