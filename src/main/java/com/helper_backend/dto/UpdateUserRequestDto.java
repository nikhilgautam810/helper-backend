package com.helper_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {
	private String uid;
	private String fullName;
	private String emailId;
	private String phoneNumber;
}
