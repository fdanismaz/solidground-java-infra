package com.solidground.infra.auth;

import java.io.Serializable;

/**
 * @author fdanismaz
 * date: 9/18/18 1:23 PM
 */
public interface SolidgroundAuthentication extends Serializable {

    WebSessionUser getWebSessionUser();

}
