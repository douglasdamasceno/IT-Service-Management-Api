package com.dev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.domain.Support;
import com.dev.repositories.SupportRepository;

@Service
public class SupportService {
	@Autowired
	private SupportRepository supportRepository;
	
	public Support findById(Integer id) {
		return supportRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Support ID not found"));
	}
	
	public List<Support> findAll() {
		return supportRepository.findAll();
	}
	
	public Support save(Support userPostRequestBody) {
		return supportRepository.save(userPostRequestBody);
	}
	
}
