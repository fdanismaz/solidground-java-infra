package com.solidground.infra.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author furkand
 * 12/27/2018 2:08 PM
 */
@Data
@Builder
@AllArgsConstructor
public class RestApiError {

	private String title;
	private String message;
	private String type;

	/**
	 * Error Types
	 */
	public static final String DEFAULT = "default-error";
	public static final String OBJECT = "object-error";
	public static final String FIELD = "field-error";
}
