package com.solidground.infra.api;

import com.solidground.infra.api.response.RestApiResponseBody;
import com.solidground.infra.api.response.RestApiResponseBodyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.TimeZone;


/**
 * @author furkand
 * 12/26/2018 4:23 PM
 */
public class RestApiController {

	@Autowired
	protected RequestContextResolver contextResolver;

	@Autowired
	protected RestApiResponseBodyBuilder responseBodyBuilder;

	@Autowired
	protected Validator validator;

	/**
	 * If you do not set validator to the {@link WebDataBinder}, you will get
	 * message codes instead of local messages.
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	public <T> ResponseEntity<RestApiResponseBody<Resource<T>>> success(T data, Link... links) {
		return ResponseEntity.ok().body(this.responseBodyBuilder.successBody(data, links));
	}

	public <T> ResponseEntity<RestApiResponseBody<Resources<T>>> successCollection(Collection<T> data, Link... links) {
		return ResponseEntity.ok().body(this.responseBodyBuilder.successCollectionBody(data, links));
	}

	public ResponseEntity<RestApiResponseBody<?>> success() {
		return ResponseEntity.ok().body(this.responseBodyBuilder.successBody(null));
	}

	protected HttpServletRequest request() {
		return this.contextResolver.request();
	}

	protected HttpServletResponse response() {
		return this.contextResolver.response();
	}

	protected TimeZone timeZone() {
		return this.contextResolver.timeZone();
	}

}
