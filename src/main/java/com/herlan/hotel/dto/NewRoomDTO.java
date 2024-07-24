package com.herlan.hotel.dto;

import java.math.BigDecimal;
import com.herlan.hotel.entity.Room;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class NewRoomDTO {
	
	 private Long id;
	 @NotBlank
	 private String roomNumber;
	 @NotNull
	 @Min(value = 1, message = "Capacity must be at least 1")
	 private Integer capacity;
	 @Min(value = 0, message = "Price must be a positive value")
	 private BigDecimal price;
	 private Boolean available;
	 
	 
	 public NewRoomDTO(Room room) {
		 this(room.getId(), room.getRoomNumber(), room.getCapacity(), 
				 room.getPrice(), room.getAvailable());
	 }
	 

}
