package com.seoi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConstraintValidatorAdapt.class)
public @interface ConstraintAdapt {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
