package com.herlan.hotel.dto;

import java.time.LocalDate;
import com.herlan.hotel.entity.Booking;
import lombok.Getter;

@Getter

public class BookingsDTO {

	private Long id;
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;
	
	private Long user;
	
	private Long room;
	
	public BookingsDTO(Booking dados) {
		this.id = dados.getId();
		this.checkIn = dados.getCheckIn();
		this.checkOut = dados.getCheckOut();
		this.user = dados.getUser().getId();
		this.room = dados.getRoom().getId();
	}
}
