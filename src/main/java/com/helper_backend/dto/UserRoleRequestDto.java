package com.helper_backend.dto;

import com.helper_backend.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleRequestDto {
	private String uid;
	private Role role;
}
