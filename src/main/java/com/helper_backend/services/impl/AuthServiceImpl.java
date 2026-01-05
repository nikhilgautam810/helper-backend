package com.helper_backend.services.impl;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.helper_backend.dto.SignInRequestDto;
import com.helper_backend.dto.SignUpRequestDto;
import com.helper_backend.entity.User;
import com.helper_backend.exception.UserException;
import com.helper_backend.repository.UserRepository;
import com.helper_backend.response.SignInResponse;
import com.helper_backend.response.SignUpResponse;
import com.helper_backend.response.TokenResponse;
import com.helper_backend.security.JWTUtil;
import com.helper_backend.services.AuthService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JWTUtil jwtUtil;

	@Override
	public SignUpResponse<TokenResponse> signUp(SignUpRequestDto request) {
		System.out.println("Service Sign up:" + request.getEmailId());
		if (userRepository.findByEmailId(request.getEmailId()).isPresent()) {
			throw new UserException("User already exists with this email :" + request.getEmailId());
		}

		User user = new User();
		user.setUid(UUID.randomUUID().toString());
		user.setEmailId(request.getEmailId());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setIsDeleted(false);

		String accessToken = jwtUtil.generateAccessToken(request.getEmailId());
		String refreshToken = jwtUtil.generateRefreshToken(request.getEmailId());

		user.setRefreshToken(refreshToken);
		userRepository.save(user);
		TokenResponse tokens = new TokenResponse(accessToken, refreshToken);
		return new SignUpResponse<>(201, "Account Created Successfully!.", user.getUid(), tokens);
	}

	@Override
	public SignInResponse<TokenResponse> signIn(SignInRequestDto request) {
		System.out.println("Service Sign in:" + request.getEmailId());
		User user = userRepository.findByEmailId(request.getEmailId())
				.orElseThrow(() -> new UserException("No user found with this email : " + request.getEmailId()));

		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new UserException("Invalid credential. Please check your email or password!.");
		}

		String accessToken = jwtUtil.generateAccessToken(request.getEmailId());
		String refreshToken = jwtUtil.generateRefreshToken(request.getEmailId());

		user.setRefreshToken(refreshToken);
		userRepository.save(user);
		TokenResponse tokens = new TokenResponse(accessToken, refreshToken);

		return new SignInResponse<TokenResponse>(200, "Signed In successfully", user.getUid(), tokens);

	}

}