package com.helper_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequestDto {
	@Email
	private String emailId;
	@NotBlank
	private String password;
}
