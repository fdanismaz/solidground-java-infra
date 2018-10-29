package com.solidground.infra.api;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fdanismaz
 * date: 10/29/18 1:12 PM
 */
@Data
public class ValidationError {

    private int code;
    private String title;
    private List<ValidationErrorItem> validationErrorItems;

    public ValidationError() {
        this.code = HttpStatus.BAD_REQUEST.value();
        this.title = "Validation Error";
        this.validationErrorItems = new ArrayList<>();
    }

    public ValidationError withFieldValidationError(ValidationErrorItem validationErrorItem) {
        this.validationErrorItems.add(validationErrorItem);
        return this;
    }

}
