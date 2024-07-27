package com.herlan.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herlan.hotel.dto.BookingsDTO;
import com.herlan.hotel.dto.NewBookingDTO;
import com.herlan.hotel.entity.Booking;
import com.herlan.hotel.repository.BookingRepository;
import com.herlan.hotel.service.BookingService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping
	public List<BookingsDTO> listBookings(){
		return repository.findAll().stream().map(BookingsDTO::new).toList();
	}
	
	@PostMapping
	@Transactional
	public void create(@RequestBody @Valid NewBookingDTO dados) {
		
		var newBooking = new Booking(dados);
		
		if (bookingService.checkAvailability(newBooking)) {
			repository.save(newBooking);
		} else {	
			 throw new RuntimeException("The room is not available for the selected dates.");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	@Transactional
	public void delete(@PathVariable Long id) {
		var booking = repository.getReferenceById(id);
		repository.delete(booking);
	}
	
}
