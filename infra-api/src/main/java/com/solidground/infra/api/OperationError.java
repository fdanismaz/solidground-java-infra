package com.solidground.infra.api;

/**
 * @author fdanismaz
 * date: 10/29/18 1:05 PM
 */
public class OperationError extends OperationResult<Error> {

    public OperationError(Error error) {
        super(false, error);
    }
}
