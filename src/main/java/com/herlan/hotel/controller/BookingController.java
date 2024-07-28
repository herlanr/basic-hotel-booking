package com.herlan.hotel.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
    @GetMapping("/checkAvailability")
    public ResponseEntity<Boolean> checkAvailability(@RequestParam Long roomId, @RequestParam LocalDate checkIn, @RequestParam LocalDate checkOut) {
        boolean isAvailable = bookingService.checkAvailability(roomId, checkIn, checkOut);
        return ResponseEntity.ok(isAvailable);
    }
    
    @GetMapping("/unavailableDates")
    public ResponseEntity<List<LocalDate>> getUnavailableDates(@RequestParam Long roomId) {
        List<LocalDate> unavailableDates = bookingService.getUnavailableDates(roomId);
        return ResponseEntity.ok(unavailableDates);
    }
	
	@PostMapping
	@Transactional
	public void create(@RequestBody @Valid NewBookingDTO dados) {
		
		var newBooking = new Booking(dados);
		
		if (bookingService.checkAvailability(dados.getRoom(), dados.getCheckIn(), dados.getCheckOut())) {
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
