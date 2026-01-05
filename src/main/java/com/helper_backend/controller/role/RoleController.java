package com.helper_backend.controller.role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helper_backend.dto.UidRequestDto;
import com.helper_backend.dto.UserRoleRequestDto;
import com.helper_backend.response.GlobalResponse;
import com.helper_backend.response.RoleResponse;
import com.helper_backend.services.RoleService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/roles")
public class RoleController {

	private RoleService roleService;

	@PostMapping("/get")
	public ResponseEntity<GlobalResponse<RoleResponse>> getUserRole(@RequestBody UidRequestDto request) {
		return ResponseEntity.ok(roleService.getUserRole(request));
	}

	@PutMapping("/update")
	public ResponseEntity<GlobalResponse<RoleResponse>> updateUserRole(@RequestBody UserRoleRequestDto request) {
		return ResponseEntity.ok(roleService.updateUserRole(request));
	}
}
