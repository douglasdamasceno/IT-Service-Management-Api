package com.dev.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.domain.Support;
import com.dev.services.SupportService;

@Controller()
@RequestMapping("supports")
public class SupportController {
	
	@Autowired
	private SupportService supportService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Support> findById(@PathVariable Integer id){
		Support support = supportService.findById(id);
		return ResponseEntity.ok(support);
	}
	
	@GetMapping()
	public ResponseEntity<List<Support>> findAll(){
		return ResponseEntity.ok(supportService.findAll());
	}
	
	@PostMapping(consumes="application/json")
    public ResponseEntity<Support> save(@RequestBody @Valid Support supportPostRequestBody) {
        return new ResponseEntity<>(supportService.save(supportPostRequestBody), HttpStatus.CREATED);
    }
	
}
