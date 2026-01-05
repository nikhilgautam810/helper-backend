package com.helper_backend.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helper_backend.dto.SignInRequestDto;
import com.helper_backend.dto.SignUpRequestDto;
import com.helper_backend.response.SignInResponse;
import com.helper_backend.response.SignUpResponse;
import com.helper_backend.response.TokenResponse;
import com.helper_backend.services.AuthService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	@PostMapping("/signUp")
	public ResponseEntity<SignUpResponse<TokenResponse>> signUp(@RequestBody SignUpRequestDto request) {
		return ResponseEntity.ok(authService.signUp(request));
	}

	@PostMapping("/signIn")
	public ResponseEntity<SignInResponse<TokenResponse>> signIn(@RequestBody SignInRequestDto request) {
		return ResponseEntity.ok(authService.signIn(request));
	}
}
