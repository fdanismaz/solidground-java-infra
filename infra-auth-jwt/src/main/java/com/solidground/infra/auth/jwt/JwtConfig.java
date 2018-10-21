package com.solidground.infra.auth.jwt;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author fdanismaz
 * date: 10/21/18 4:13 PM
 */
@Getter
@Configuration
@PropertySource("jwt.properties")
public class JwtConfig {

    @Value("${com.solidground.auth.jwt.url:/login}")
    private String url;

    @Value("${com.solidground.auth.jwt.header:Authorization}")
    private String header;

    @Value("${com.solidground.auth.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${com.solidground.auth.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${com.solidground.auth.jwt.secret}")
    private String secret;
}
