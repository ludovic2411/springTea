package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.entities.Greeting;

@RestController
@RequestMapping("/hello")
public class GreetingController {
	@GetMapping("")
	public Greeting hello(@RequestParam String name) {
		return new Greeting(1,name);
	}
}
