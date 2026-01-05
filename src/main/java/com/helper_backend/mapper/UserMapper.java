package com.helper_backend.mapper;

import com.helper_backend.dto.UserDto;
import com.helper_backend.entity.User;

public class UserMapper {

	public static UserDto mapToUserDto(User user) {
		return new UserDto(user.getUid(), user.getFullName(), user.getEmailId(), user.getPhoneNumber(), user.getRole(),
				user.getCreatedAt(), user.getUpdatedAt());
	}

	public static User mapToUser(UserDto userDto) {
		User user = new User();
		user.setUid(userDto.getUid());
		user.setFullName(userDto.getFullName());
		user.setEmailId(userDto.getEmailId());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setRole(userDto.getRole());
		user.setIsDeleted(false);
		return user;
	}

}
