package com.herlan.hotel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private RoomRepository repository;
	
	@GetMapping
	public ResponseEntity<List<DetailedRoomDTO>>  listRooms(){
		return ResponseEntity.ok(repository.findAll().stream()
				.map(DetailedRoomDTO::new).toList()); 
	}	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> register(@RequestBody @Valid NewRoomDTO newRoomDTO) {
		repository.save(new Room(newRoomDTO));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<Void> update(@RequestBody @Valid UpdateRoomDTO updateRoomDTO) {
		var room = repository.getReferenceById(updateRoomDTO.getId());
		room.update(updateRoomDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetailedRoomDTO> detail(@PathVariable Long id) {
	    var room = repository.getReferenceById(id);
	    DetailedRoomDTO dto = new DetailedRoomDTO(room);
	    return ResponseEntity.ok(dto);
	}
	
	@PutMapping("disable/{id}")
	@Transactional
	public ResponseEntity<Void> disable (@PathVariable Long id){
		var room = repository.getReferenceById(id);
		room.setAvailable(false);
		return ResponseEntity.ok().build();
	}
}
