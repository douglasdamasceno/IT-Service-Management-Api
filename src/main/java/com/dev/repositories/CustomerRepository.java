package com.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
