package com.helper_backend.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helper_backend.dto.UidRequestDto;
import com.helper_backend.dto.UpdateUserRequestDto;
import com.helper_backend.dto.UserDto;
import com.helper_backend.response.GlobalResponse;
import com.helper_backend.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;

	@PostMapping("/getUser")
	public ResponseEntity<GlobalResponse<UserDto>> getUser(@RequestBody UidRequestDto request) {
		System.out.println("Controller : " + request.getUid());
		return ResponseEntity.ok(userService.getUser(request));
	}

	@PutMapping("/updateUser")
	public ResponseEntity<GlobalResponse<UserDto>> updateUser(@RequestBody UpdateUserRequestDto request) {
		System.out.println("Controller : " + request.getEmailId() + request.getFullName() + request.getPhoneNumber());
		return ResponseEntity.ok(userService.updateUser(request));
	}
}
