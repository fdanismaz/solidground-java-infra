package com.solidground.infra.commons.error;

import lombok.Getter;

/**
 * @author fdanismaz
 * date: 9/18/18 1:44 PM
 */
@Getter
public class SolidgroundHttpRuntimeException extends SolidgroundRuntimeException implements SolidgroundHttpError {

    protected int httpStatusCode;

    public SolidgroundHttpRuntimeException(String message, Throwable cause, String title, int httpStatusCode) {
        super(message, cause, title);
        this.httpStatusCode = httpStatusCode;
    }

    public SolidgroundHttpRuntimeException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace, String title, int httpStatusCode) {
        super(message, cause, enableSuppression, writableStackTrace, title);
        this.httpStatusCode = httpStatusCode;
    }
}
