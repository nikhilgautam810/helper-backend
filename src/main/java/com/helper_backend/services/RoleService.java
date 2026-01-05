package com.helper_backend.services;

import com.helper_backend.dto.UidRequestDto;
import com.helper_backend.dto.UserRoleRequestDto;
import com.helper_backend.response.GlobalResponse;
import com.helper_backend.response.RoleResponse;

public interface RoleService {
	GlobalResponse<RoleResponse> getUserRole(UidRequestDto request);

	GlobalResponse<RoleResponse> updateUserRole(UserRoleRequestDto request);
}
