package com.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.domain.Support;

@Repository
public interface SupportRepository  extends JpaRepository<Support, Integer>{

}
