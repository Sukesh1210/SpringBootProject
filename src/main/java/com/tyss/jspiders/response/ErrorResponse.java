package com.tyss.jspiders.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.tyss.jspiders.dto.ActorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class ErrorResponse {
	private String message;
	private HttpStatus status;
	private LocalDateTime timeStamp;

}
