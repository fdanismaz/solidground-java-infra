package com.solidground.infra.auth;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fdanismaz
 * date: 9/18/18 1:24 PM
 */
@Data
@Builder
public class WebSessionUser implements Serializable {

    private static final long serialVersionUID = 9022604589795897914L;

    private String username;
    private String email;
    private String name;
    private String surname;

    public String fullname() {
        return new StringBuilder().append(this.name).append(" ").append(this.surname).toString();
    }
}
