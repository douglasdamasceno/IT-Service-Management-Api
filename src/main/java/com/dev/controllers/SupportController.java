package com.dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dev.domain.Support;
import com.dev.services.SupportService;

@Controller("support")
public class SupportController {
	
	@Autowired
	private SupportService supportService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Support> findById(@PathVariable Integer id){
		Support support = supportService.findById(id);
		return ResponseEntity.ok(support);
	}
}
