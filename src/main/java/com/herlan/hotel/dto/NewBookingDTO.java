package com.herlan.hotel.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter

public class NewBookingDTO {
	
	private Long id;
	
	@NotNull
	@FutureOrPresent
	private LocalDate checkIn;
	
	@NotNull
	@Future
	private LocalDate checkOut;
	
	@NotNull
	private Long user;
	
	@NotNull
	private Long room;
}
