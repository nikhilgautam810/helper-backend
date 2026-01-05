package com.helper_backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GlobalResponse<T> {
	private int status;
	private String message;
	private T data;
}
