package com.herlan.hotel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.herlan.hotel.entity.Booking;
import com.herlan.hotel.repository.BookingRepository;

@Service

public class BookingService {
	
	@Autowired
	private BookingRepository repository;

	public boolean checkAvailability(Long roomId, LocalDate checkIn, LocalDate checkOut) {
		List<Booking> bookings  = repository.findBookingsForRoom(roomId, checkIn, checkOut);
		
		return bookings.isEmpty();	
	}
	
    public List<LocalDate> getUnavailableDates(Long roomId) {
        List<Booking> bookings = repository.findByRoomId(roomId);
        List<LocalDate> unavailableDates = new ArrayList<>();

        for (Booking booking : bookings) {
            LocalDate date = booking.getCheckIn();
            while (!date.isAfter(booking.getCheckOut())) {
                unavailableDates.add(date);
                date = date.plusDays(1);
            }
        }

        return unavailableDates;
    }
}

