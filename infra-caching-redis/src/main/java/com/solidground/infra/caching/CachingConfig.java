package com.solidground.infra.caching;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author fdanismaz
 * date: 9/18/18 11:44 AM
 */
@EnableCaching
@Configuration
@PropertySource("caching.properties")
public class CachingConfig {
}
