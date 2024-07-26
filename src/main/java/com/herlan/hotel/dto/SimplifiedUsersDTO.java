package com.herlan.hotel.dto;

import com.herlan.hotel.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class SimplifiedUsersDTO {
	
	private Long id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Email
	private String email;
	

	public SimplifiedUsersDTO(User user) {
		this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
	}	
}
