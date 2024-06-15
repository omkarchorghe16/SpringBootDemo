package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.SampleData;

@RestController
@RequestMapping(value = "/raw.githubusercontent.com/stleary/JSON-java/master/src/test/resources")
public class DemoController {

	@Autowired
	com.demo.service.DemoService demoService;
	
	@PostMapping(value = "/Issue593.json" ,consumes = "application/json")
	public ResponseEntity<SampleData> fetchData(@RequestBody SampleData str) {
		
		demoService.fetchData(str);
		
		return ResponseEntity.ok(str);
	}
	
	
	
}
