package com.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.domain.repository.CustomerRepository;
import com.domain.repository.HibernateCustomerRepositoryImpl;
import com.domain.service.CustomerService;
import com.domain.service.CustomerServiceImpl;

@Configuration
@ComponentScan({ "com.domain" })
public class AppConfig {

	 @Bean(name = "customerService")
	 public CustomerService getCustomerService() {
	 CustomerServiceImpl service = new
	 CustomerServiceImpl(getCustomerRepository());
//	 CustomerServiceImpl service = new CustomerServiceImpl();
//	 service.setCustomerRepository(getCustomerRepository());
	 return service;
	 }

	 @Bean(name = "customerRepository")
	 public CustomerRepository getCustomerRepository() {
	 return new HibernateCustomerRepositoryImpl();
	 }
}
