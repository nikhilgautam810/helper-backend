package com.helper_backend.dto;

import java.util.Date;

import com.helper_backend.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
	private String uid;
	private String fullName;
	private String emailId;
	private String phoneNumber;
	private Role role;
	private Date createdAt;
	private Date updatedAt;
}
