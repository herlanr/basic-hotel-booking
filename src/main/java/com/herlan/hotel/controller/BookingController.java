package com.herlan.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@GetMapping
	public String helloWorld() {
		return "Welcome to booking";
	}
	
}
