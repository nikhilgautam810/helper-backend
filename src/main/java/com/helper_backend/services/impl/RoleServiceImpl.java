package com.helper_backend.services.impl;

import org.springframework.stereotype.Service;

import com.helper_backend.dto.UidRequestDto;
import com.helper_backend.dto.UserRoleRequestDto;
import com.helper_backend.entity.Role;
import com.helper_backend.entity.User;
import com.helper_backend.exception.UserException;
import com.helper_backend.repository.UserRepository;
import com.helper_backend.response.GlobalResponse;
import com.helper_backend.response.RoleResponse;
import com.helper_backend.services.RoleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

	private UserRepository userRepository;

	@Override
	public GlobalResponse<RoleResponse> getUserRole(UidRequestDto request) {
		System.out.println("Get user role:" + request.getUid());
		User user = userRepository.findByUid(request.getUid()).orElseThrow(
				() -> new UserException("Invalid Uid. User not present with this uid : " + request.getUid()));
		Role userRole = user.getRole();
		RoleResponse roleResponse = new RoleResponse(userRole);
		return new GlobalResponse<RoleResponse>(200, "User role fetched successfully!", roleResponse);
	}

	@Override
	public GlobalResponse<RoleResponse> updateUserRole(UserRoleRequestDto request) {
		User user = userRepository.findByUid(request.getUid()).orElseThrow(
				() -> new UserException("Invalid Uid. User not present with this uid : " + request.getUid()));
		user.setRole(request.getRole());
		User updatedUser = userRepository.save(user);

		RoleResponse roleResponse = new RoleResponse(updatedUser.getRole());
		return new GlobalResponse<RoleResponse>(200, "User role updated successfully!", roleResponse);
	}

}
