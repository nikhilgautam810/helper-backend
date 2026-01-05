package com.helper_backend.services.impl;

import org.springframework.stereotype.Service;

import com.helper_backend.dto.UidRequestDto;
import com.helper_backend.dto.UpdateUserRequestDto;
import com.helper_backend.dto.UserDto;
import com.helper_backend.entity.User;
import com.helper_backend.exception.UserException;
import com.helper_backend.mapper.UserMapper;
import com.helper_backend.repository.UserRepository;
import com.helper_backend.response.GlobalResponse;
import com.helper_backend.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public GlobalResponse<UserDto> getUser(UidRequestDto request) {
		System.out.println("Service : " + request.getUid());
		User user = userRepository.findByUid(request.getUid()).orElseThrow(
				() -> new UserException("Invalid Uid. User not present with this uid : " + request.getUid()));

		UserDto userDto = UserMapper.mapToUserDto(user);

		return new GlobalResponse<UserDto>(200, "User fetched successfully!.", userDto);
	}

	@Override
	public GlobalResponse<UserDto> updateUser(UpdateUserRequestDto request) {
		User user = userRepository.findByUid(request.getUid()).orElseThrow(
				() -> new UserException("Invalid Uid. User not present with this uid : " + request.getUid()));
		user.setFullName(request.getFullName());
		user.setEmailId(request.getEmailId());
		user.setPhoneNumber(request.getPhoneNumber());

		User updatedUser = userRepository.save(user);
		UserDto userDto = UserMapper.mapToUserDto(updatedUser);
		return new GlobalResponse<UserDto>(200, "User Updated successfully!.", userDto);
	}
}
