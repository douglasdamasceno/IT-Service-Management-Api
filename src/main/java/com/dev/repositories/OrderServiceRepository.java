package com.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.domain.OrderService;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, Integer>{

}
