package com.herlan.hotel.entity;

import java.time.LocalDate;

import com.herlan.hotel.dto.NewBookingDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "booking")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private LocalDate checkIn;
	
	@NotNull
	@Future
	private LocalDate checkOut;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "roomId")
	private Room room;
	
    public Booking(NewBookingDTO dados) {
        this.checkIn = dados.getCheckIn();
        this.checkOut = dados.getCheckOut();
        this.user = new User(dados.getUser());   // Creating new instance only with ID
        this.room = new Room(dados.getRoom());  // Creating new instance only with ID
    }	
	
}
