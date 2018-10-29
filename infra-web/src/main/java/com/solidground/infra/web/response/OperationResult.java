package com.solidground.infra.web.response;

import lombok.Data;

import java.time.Instant;

/**
 * @author fdanismaz
 * date: 10/29/18 1:02 PM
 */
@Data
public class OperationResult<T> {

    protected boolean success;
    protected T data;
    protected Instant time;

    public OperationResult(boolean success, T data) {
        this.success = success;
        this.data = data;
        this.time = Instant.now();
    }

    public OperationResult() {
        this.success = true;
        this.data = null;
        this.time = Instant.now();
    }
}
