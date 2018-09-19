package com.solidground.infra.commons.error;

import lombok.Getter;

/**
 * @author fdanismaz
 * date: 9/18/18 1:43 PM
 */
@Getter
public class SolidgroundRuntimeException extends RuntimeException implements SolidgroundError {

    protected final String title;

    public SolidgroundRuntimeException(String message, Throwable cause, String title) {
        super(message, cause);
        this.title = title;
    }

    public SolidgroundRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
                                String title) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.title = title;
    }
}
