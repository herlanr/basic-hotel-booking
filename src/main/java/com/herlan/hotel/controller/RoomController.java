package com.herlan.hotel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herlan.hotel.dto.DetailedRoomDTO;
import com.herlan.hotel.dto.NewRoomDTO;
import com.herlan.hotel.dto.UpdateRoomDTO;
import com.herlan.hotel.entity.Room;
import com.herlan.hotel.repository.RoomRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping
	public List<DetailedRoomDTO> listRooms(){
		return roomRepository.findAll().stream().map(DetailedRoomDTO::new).toList();
	}
	
	@PostMapping
	@Transactional
	public void register(@RequestBody @Valid NewRoomDTO newRoomDTO) {
		roomRepository.save(new Room(newRoomDTO));
	}
	
	@PutMapping
	@Transactional
	public void update(@RequestBody @Valid UpdateRoomDTO updateRoomDTO) {
		var room = roomRepository.getReferenceById(updateRoomDTO.getId());
		room.update(updateRoomDTO);
	}
	
	@GetMapping("/{id}")
	public DetailedRoomDTO detail(@PathVariable Long id) {
	    var room = roomRepository.getReferenceById(id);
	    return new DetailedRoomDTO(room);
	}
	
	
}
