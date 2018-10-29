package com.solidground.infra.api;

/**
 * @author fdanismaz
 * date: 10/29/18 1:16 PM
 */
public class OperationValidationError extends OperationResult<ValidationError> {

    public OperationValidationError(ValidationError error) {
        super(false, error);
    }
}
