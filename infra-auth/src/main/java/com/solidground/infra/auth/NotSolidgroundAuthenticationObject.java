package com.solidground.infra.auth;

import com.solidground.infra.commons.error.SolidgroundHttpRuntimeException;
import com.solidground.infra.commons.i18n.MessageSourceReader;

/**
 * @author fdanismaz
 * date: 9/18/18 1:45 PM
 */
public class NotSolidgroundAuthenticationObject extends SolidgroundHttpRuntimeException {

    private static final long serialVersionUID = -2631120292044589273L;

    public NotSolidgroundAuthenticationObject(MessageSourceReader messageSourceReader) {
        super(messageSourceReader.getMessage("solidground.error.security.message"), null,
                messageSourceReader.getMessage("solidground.error.security.title"), 500);
    }

    public NotSolidgroundAuthenticationObject(Throwable cause, MessageSourceReader messageSourceReader) {
        super(messageSourceReader.getMessage("solidground.error.security.message"), cause,
                messageSourceReader.getMessage("solidground.error.security.title"), 500);
    }
}
