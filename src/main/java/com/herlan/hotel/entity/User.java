package com.herlan.hotel.entity;

import com.herlan.hotel.dto.NewUserDTO;
import com.herlan.hotel.dto.UpdatedUserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	public User(NewUserDTO dados) {
		this.firstName = dados.getFirstName();
		this.lastName = dados.getLastName();
		this.email = dados.getEmail();
		this.password = dados.getPassword();
	}
	
	public void update(UpdatedUserDTO dados) {
		this.email = dados.getEmail();
	}

	public User(Long id) {
		this.id = id;
	}

}

	
