package com.tyss.jspiders.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.jspiders.response.ErrorResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ErrorResponse> movieNotFound(MovieNotFoundException e) {
		return ResponseEntity
				.<ErrorResponse>ofNullable(ErrorResponse.builder().message("Movie with given title not found")
						.status(HttpStatus.NOT_FOUND).timeStamp(LocalDateTime.now()).build());

	}

}
