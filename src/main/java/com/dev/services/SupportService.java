package com.dev.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.domain.Support;
import com.dev.repositories.SupportRepository;

@Service
public class SupportService {
	@Autowired
	private SupportRepository supportRepository;
	
	public Support findById(Integer id) {
		Optional<Support> support = supportRepository.findById(id);
		return support.orElse(null);
	}
}
