package com.herlan.hotel.entity;

import java.math.BigDecimal;

import com.herlan.hotel.dto.NewRoomDTO;
import com.herlan.hotel.dto.UpdateRoomDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "room")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Room {
	
	public Room(NewRoomDTO newRoomDTO) {
        this.id = newRoomDTO.getId();
        this.roomNumber = newRoomDTO.getRoomNumber();
        this.capacity = newRoomDTO.getCapacity();
        this.price = newRoomDTO.getPrice();
        this.available = newRoomDTO.getAvailable();
    }
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String roomNumber;
	
	@NotNull
	private Integer capacity;
	
	@NotNull
	private BigDecimal price;
	
	private Boolean available;

	public void update(UpdateRoomDTO updateRoomDTO) {
		if (updateRoomDTO.getRoomNumber() != null) {
			this.roomNumber = updateRoomDTO.getRoomNumber();
		}
		
		if (updateRoomDTO.getCapacity() != null) {
			this.capacity = updateRoomDTO.getCapacity();
		}
		
		if (updateRoomDTO.getPrice() != null) {
			this.price = updateRoomDTO.getPrice();
		}
		
		if (updateRoomDTO.getAvailable() != null) {
			this.available = updateRoomDTO.getAvailable();
		}		
	}

}
