package com.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
