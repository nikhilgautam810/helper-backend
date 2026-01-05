package com.helper_backend.services;

import com.helper_backend.dto.SignInRequestDto;
import com.helper_backend.dto.SignUpRequestDto;
import com.helper_backend.response.SignInResponse;
import com.helper_backend.response.SignUpResponse;
import com.helper_backend.response.TokenResponse;

public interface AuthService {
	SignUpResponse<TokenResponse> signUp(SignUpRequestDto request);

	SignInResponse<TokenResponse> signIn(SignInRequestDto request);

}
