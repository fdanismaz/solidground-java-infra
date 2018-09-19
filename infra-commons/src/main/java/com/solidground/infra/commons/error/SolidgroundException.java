package com.solidground.infra.commons.error;

import lombok.Getter;

/**
 * @author fdanismaz
 * date: 9/18/18 1:38 PM
 */
@Getter
public class SolidgroundException extends Exception implements SolidgroundError {

    protected final String title;

    public SolidgroundException(String message, Throwable cause, String title) {
        super(message, cause);
        this.title = title;
    }

    public SolidgroundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
                                String title) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.title = title;
    }
}
