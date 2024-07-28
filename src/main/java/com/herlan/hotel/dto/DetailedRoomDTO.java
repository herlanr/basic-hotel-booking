package com.herlan.hotel.dto;

import java.math.BigDecimal;
import com.herlan.hotel.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class DetailedRoomDTO {
	
	 private Long id;
	 private String roomNumber;
	 private Integer capacity;
	 private BigDecimal price;

	 public DetailedRoomDTO(Room room) {
		 this(room.getId(), room.getRoomNumber(), room.getCapacity(), 
				 room.getPrice());
	 }
	 
}
