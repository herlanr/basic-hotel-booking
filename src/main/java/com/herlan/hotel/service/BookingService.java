package com.herlan.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.herlan.hotel.dto.NewBookingDTO;
import com.herlan.hotel.entity.Booking;
import com.herlan.hotel.repository.BookingRepository;

@Service

public class BookingService {
	
	@Autowired
	private BookingRepository repository;

	public boolean checkAvailability(Booking dados) {
		List<Booking> bookings  = repository.findBookingsForRoom(dados.getRoom().getId(), 
				dados.getCheckIn(), dados.getCheckOut());
		
		return bookings.isEmpty();	
	}
	
	

}
