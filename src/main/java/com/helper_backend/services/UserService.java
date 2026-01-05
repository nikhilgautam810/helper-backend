package com.helper_backend.services;

import com.helper_backend.dto.UidRequestDto;
import com.helper_backend.dto.UpdateUserRequestDto;
import com.helper_backend.dto.UserDto;
import com.helper_backend.response.GlobalResponse;

public interface UserService {
	GlobalResponse<UserDto> getUser(UidRequestDto request);

	GlobalResponse<UserDto> updateUser(UpdateUserRequestDto request);
}
