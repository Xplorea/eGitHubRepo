package com.domain.repository;

import java.util.List;

import com.domain.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}