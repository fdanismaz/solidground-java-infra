package com.solidground.infra.commons.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

/**
 * @author fdanismaz
 * date: 9/18/18 12:18 PM
 */
public class NotEmptyUuidValidator implements ConstraintValidator<NotEmptyUuid, UUID> {

    @Override
    public void initialize(NotEmptyUuid annotation) {
        return;
    }

    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext context) {
        return uuid != null && !uuid.equals(new UUID(0,0));
    }

}
