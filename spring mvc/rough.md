#SET UP MAVEN PROJECT
maven-archetype-webapp

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.demo</groupId>
  <artifactId>3a-spring-rest-crud</artifactId>
  <packaging>war</packaging>
  <version>0.0.1-SNAPSHOT</version>
  <name>3a-spring-rest-crud Maven Webapp</name>
  <url>http://maven.apache.org</url>
  
  	<properties>
		<!-- <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding> -->
		<java.version>1.8</java.version>
		<!-- <spring.version>5.1.7.RELEASE</spring.version> -->
		<spring.version>4.2.1.RELEASE</spring.version>
	</properties>
	
  <dependencies>
  <!-- spring dependencies -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${spring.version}</version>
		</dependency>
		
		 <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
             <version>2.4.1</version>
        </dependency>
<!-- servlet dependency -->
    <dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
		</dependency>
		
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <build>
    <finalName>3a-spring-rest-crud</finalName>
    <plugins>
		<!-- maven compiler configuration -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.7.0</version>
				<configuration>
					<target>1.8</target>
					<source>1.8</source>
				</configuration>
			</plugin>
			<!-- <plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>3.2.2</version>
			</plugin> -->
		</plugins>
  </build>
</project>

#CONFIGURE WEB.XML
[src\main\webapp\WEB-INF\web.xml]
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
	<display-name>Archetype Created Web Application</display-name>
	<!-- <welcome-file-list> <welcome-file>index.html</welcome-file> <welcome-file>index.htm</welcome-file> 
		<welcome-file>index.jsp</welcome-file> <welcome-file>default.html</welcome-file> 
		<welcome-file>default.htm</welcome-file> <welcome-file>default.jsp</welcome-file> 
		</welcome-file-list> -->

	<!-- Configuring the front controller -->
	<servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>/rest/*</url-pattern>
	</servlet-mapping>
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/dispatcher-servlet.xml</param-value>
	</context-param>
	<!-- <listener> <listener-class> org.springframework.web.context.ContextLoaderListener 
		</listener-class> </listener> -->
</web-app>

#CREATE SPRING BEAN CONFIGURATONS
[src\main\webapp\WEB-INF\dispatcher-servlet.xml]
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.2.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd">

	<context:component-scan base-package="com.demo"></context:component-scan>
	<mvc:annotation-driven></mvc:annotation-driven>

</beans>