package com.solidground.infra.commons.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author fdanismaz
 * date: 9/18/18 12:19 PM
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyUuidValidator.class)
public @interface NotEmptyUuid {

    /**
     * Hata olması durumunda gösterilecek mesaj.
     *
     * @return string
     */
    String message() default "{tybs.altyapi.dogrulama.bos_uuid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
