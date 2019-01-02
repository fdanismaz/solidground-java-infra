package com.solidground.infra.api.response;

import com.solidground.infra.api.RequestContextResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author furkand
 * 12/27/2018 2:02 PM
 */
@Component
public class RestApiResponseBodyBuilder {

	@Autowired
	private RequestContextResolver requestContextResolver;

	public <T> RestApiResponseBody<Resource<T>> successBody(T data, Link... links) {
		return new RestApiResponseBody<>(
				this.requestContextResolver.clientTime(),
				"success",
				this.requestContextResolver.request().getServletPath(),
				this.resource(data, links),
				null);
	}

	public <T> RestApiResponseBody<Resources<T>> successCollectionBody(Collection<T> data, Link... links) {
		return new RestApiResponseBody<>(
				this.requestContextResolver.clientTime(),
				"success",
				this.requestContextResolver.request().getServletPath(),
				this.resources(data, links),
				null);
	}

	public <T> RestApiResponseBody<T> errorBody(String errorMessage) {
		return (RestApiResponseBody<T>) RestApiResponseBody.builder()
				.data(null)
				.path(this.requestContextResolver.request().getServletPath())
				.timestamp(this.requestContextResolver.clientTime())
				.errors(new RestApiError[] {
						RestApiError.builder()
								.type(RestApiError.DEFAULT)
								.message(errorMessage)
								.build() })
				.message(errorMessage).build();
	}

	public RestApiResponseBody<Object> errorBody(BindingResult validationResult) {
		return RestApiResponseBody.builder()
				.data(null)
				.path(this.requestContextResolver.request().getServletPath())
				.timestamp(this.requestContextResolver.clientTime())
				.message("Validation error")
				.errors(this.validationErrors(validationResult))
				.build();
	}

	public RestApiResponseBody<Object> errorBody(MethodArgumentTypeMismatchException exception) {
		return RestApiResponseBody.builder()
				.data(null)
				.path(this.requestContextResolver.request().getServletPath())
				.timestamp(this.requestContextResolver.clientTime())
				.message("Validation error")
				.errors(new RestApiError[] {
						RestApiError.builder()
								.type(RestApiError.DEFAULT)
								.title(exception.getParameter().getParameterName())
								.message(exception.getMessage())
								.build() })
				.build();
	}

	public RestApiResponseBody<Object> errorBody(MissingServletRequestParameterException exception) {
		return RestApiResponseBody.builder()
				.data(null)
				.path(this.requestContextResolver.request().getServletPath())
				.timestamp(this.requestContextResolver.clientTime())
				.message("Validation error")
				.errors(new RestApiError[] {
						RestApiError.builder()
								.type(RestApiError.DEFAULT)
								.title(exception.getParameterName())
								.message(exception.getMessage())
								.build() })
				.build();
	}

	protected RestApiError[] validationErrors(BindingResult validationResult) {
		List<RestApiError> result = new ArrayList<>();
		for (ObjectError objectError : validationResult.getGlobalErrors()) {
			RestApiError error = RestApiError.builder()
					.title(objectError.getObjectName())
					.message(objectError.getDefaultMessage())
					.type(RestApiError.OBJECT)
					.build();
			result.add(error);
		}
		for (FieldError fieldError : validationResult.getFieldErrors()) {
			RestApiError error = RestApiError.builder()
					.title(fieldError.getField())
					.message(fieldError.getDefaultMessage())
					.type(RestApiError.FIELD)
					.build();
			result.add(error);
		}
		return result.toArray(new RestApiError[result.size()]);
	}

	protected <T> Resource<T> resource(T data, Link... links) {
		return new Resource<>(data, links);
	}

	protected <T> Resources<T> resources(Collection<T> data, Link... links) {
		return new Resources<>(data, links);
	}
}
