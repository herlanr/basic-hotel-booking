package com.herlan.hotel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter

public class UpdatedUserDTO {
	
	@NotNull
	private Long id;
	
	@NotBlank
	@Email
	private String email;

}
