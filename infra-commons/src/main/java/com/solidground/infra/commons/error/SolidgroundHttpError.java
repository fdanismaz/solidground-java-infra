package com.solidground.infra.commons.error;

/**
 * @author fdanismaz
 * date: 9/18/18 1:30 PM
 */
public interface SolidgroundHttpError extends SolidgroundError {

    int getHttpStatusCode();
}
