package com.solidground.infra.commons.error;

import lombok.Getter;

/**
 * @author fdanismaz
 * date: 9/18/18 1:41 PM
 */
@Getter
public class SolidgroundHttpException extends SolidgroundException implements SolidgroundHttpError {

    protected int httpStatusCode;

    public SolidgroundHttpException(String message, Throwable cause, String title, int httpStatusCode) {
        super(message, cause, title);
        this.httpStatusCode = httpStatusCode;
    }

    public SolidgroundHttpException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace, String title, int httpStatusCode) {
        super(message, cause, enableSuppression, writableStackTrace, title);
        this.httpStatusCode = httpStatusCode;
    }
}
