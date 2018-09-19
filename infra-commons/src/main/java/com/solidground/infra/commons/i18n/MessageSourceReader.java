package com.solidground.infra.commons.i18n;

/**
 * @author fdanismaz
 * date: 9/18/18 1:55 PM
 */
public interface MessageSourceReader {

    /**
     * Should read the corresponding value of the given messageCode parameter.
     * How it does depends on the developer implementing this interface.
     * One possible solution is to use Spring's MessageSource bean
     *
     * @param messageCode
     * @return
     */
    String getMessage(String messageCode);
}
