package com.solidground.infra.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author furkand
 * 12/27/2018 10:53 AM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestApiResponseBody<T> {

	private LocalDateTime timestamp;
	private String message;
	private String path;
	private T data;
	private RestApiError[] errors;
}
