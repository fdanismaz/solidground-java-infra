package com.solidground.infra.api;

import com.solidground.infra.api.response.RestApiResponseBody;
import com.solidground.infra.api.response.RestApiResponseBodyBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * If an exception is thrown and not handled until the end of the responsible handler, this class
 * catches that exception. Several exception handlers are implemented for different situations.
 *
 * @author furkand
 * 12/26/2018 4:51 PM
 */
@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class RestApiControllerAdvice {

	@Autowired
	private RestApiResponseBodyBuilder responseBodyBuilder;

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> runtimeException(RuntimeException exception) {
		log.error(exception.getMessage(), exception);
		RestApiResponseBody<Object> responseBody =
				this.responseBodyBuilder.errorBody(exception.getMessage());
		return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> invalidArgument(MethodArgumentNotValidException exception) {
		log.error(exception.getMessage(), exception);
		RestApiResponseBody<Object> responseBody = this.responseBodyBuilder.errorBody(exception.getBindingResult());
		return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> argumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
		log.error(exception.getMessage(), exception);
		RestApiResponseBody<Object> responseBody = this.responseBodyBuilder.errorBody(exception);
		return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingParameter(MissingServletRequestParameterException exception) {
		log.error(exception.getMessage(), exception);
		RestApiResponseBody<Object> responseBody = this.responseBodyBuilder.errorBody(exception);
		return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> unknownException(Exception exception) {
		log.error(exception.getMessage(), exception);
		RestApiResponseBody<Object> responseBody = this.responseBodyBuilder.errorBody(exception.getMessage());
		return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
	}
}
