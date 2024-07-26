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
import com.herlan.hotel.dto.NewUserDTO;
import com.herlan.hotel.dto.SimplifiedUsersDTO;
import com.herlan.hotel.dto.UpdatedUserDTO;
import com.herlan.hotel.entity.User;
import com.herlan.hotel.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<SimplifiedUsersDTO> listUsers(){
		return repository.findAll().stream().map(SimplifiedUsersDTO::new).toList();
	}
	
	@PostMapping
	@Transactional
	public void create(@RequestBody @Valid NewUserDTO dados) {
		repository.save(new User(dados));
	}	
	
	@PutMapping
	@Transactional
	public void update(@RequestBody @Valid UpdatedUserDTO dados) {
		var user = repository.getReferenceById(dados.getId());
		user.update(dados);
	}
	
	@GetMapping("/{id}")
	public SimplifiedUsersDTO findUser(@PathVariable Long id){
		var user = repository.getReferenceById(id);
		var SimplifiedUsersDTO = new SimplifiedUsersDTO(user);
		
		return SimplifiedUsersDTO;
	}

	
	
	
}

