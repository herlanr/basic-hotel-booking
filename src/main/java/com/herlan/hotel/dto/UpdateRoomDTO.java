package com.herlan.hotel.dto;

import java.math.BigDecimal;
import com.herlan.hotel.entity.Room;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class UpdateRoomDTO {

	 private Long id;
	 
	 private String roomNumber;
	 
	 @Min(value = 1, message = "Capacity must be at least 1")
	 private Integer capacity;
	 
	 @Min(value = 0, message = "Price must be a positive value")
	 private BigDecimal price;
	 
	 private Boolean available;
	 
	 public UpdateRoomDTO(Room room) {
		 this(room.getId(), room.getRoomNumber(), room.getCapacity(), 
				 room.getPrice(), room.getAvailable());
	 }
}
