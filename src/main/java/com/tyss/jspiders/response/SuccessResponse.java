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
public class SuccessResponse {
	private String message;
	private Object data;
	private HttpStatus status;
	private LocalDateTime timeStamp;
	private String token;

}
