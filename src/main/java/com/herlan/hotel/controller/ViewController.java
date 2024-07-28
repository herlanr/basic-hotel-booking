package com.herlan.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	
	@GetMapping
	public String showIndexPage() {
		return "index";
	}
	
	
	@GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	
	@GetMapping("/home")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/rooms")
	public String showRoomsPage() {
		return "rooms";
	}
	
    @GetMapping("/register_success")
    public String showRegisterSuccessPage() {
        return "register_success";
    }
	
}
