package com.solidground.infra.auth;

import com.solidground.infra.commons.i18n.MessageSourceReader;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * To be able to use this {@link IdentityAccessor}, a {@link SolidgroundAuthentication}
 * object should be returned from the authenticate method of the
 * {@link org.springframework.security.authentication.AuthenticationProvider}.
 * Otherwise, {@link NotSolidgroundAuthenticationObject} exception will be thrown which
 * is a runtime exception.
 *
 * @author fdanismaz
 * date: 9/18/18 1:27 PM
 */
public class IdentityAccessor {

    private MessageSourceReader messageSourceReader;

    public IdentityAccessor(MessageSourceReader messageSourceReader) {
        this.messageSourceReader = messageSourceReader;
    }

    public WebSessionUser getWebSessionUser() {
        SolidgroundAuthentication auth = this.getAuthentication();
        return auth.getWebSessionUser();
    }

    private SolidgroundAuthentication getAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth instanceof SolidgroundAuthentication) {
            return (SolidgroundAuthentication)auth;
        }
        throw new NotSolidgroundAuthenticationObject(this.messageSourceReader);
    }
}
