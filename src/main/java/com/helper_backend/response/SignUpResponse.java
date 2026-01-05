package com.helper_backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignUpResponse<T> {
	private int status;
	private String message;
	private String uid;
	private T data;
}
