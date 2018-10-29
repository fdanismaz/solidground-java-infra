package com.solidground.infra.api;

import com.solidground.infra.web.resolver.ContextResolver;
import com.solidground.infra.web.response.OperationValidationError;
import com.solidground.infra.web.response.ValidationError;
import com.solidground.infra.web.response.ValidationErrorItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author fdanismaz
 * date: 10/29/18 10:03 AM
 */
public class ApiController {

    @Autowired
    protected Validator validator;

    @Autowired
    protected ContextResolver contextResolver;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    public ResponseEntity<OperationValidationError> validationError(BindingResult bindingResult) {
        ValidationError validationError = new ValidationError();
        for (ObjectError e : bindingResult.getAllErrors()) {
            ValidationErrorItem validationErrorItem = ValidationErrorItem.builder()
                    .itemName(e.getObjectName())
                    .message(e.getDefaultMessage())
                    .build();
            validationError.withFieldValidationError(validationErrorItem);
        }

        return ResponseEntity.badRequest().body(new OperationValidationError(validationError));
    }

    public <T> ResponseEntity<Resource<T>> success(T data, Link... links) {
        return ResponseEntity.ok(new Resource<>(data, links));
    }

}
