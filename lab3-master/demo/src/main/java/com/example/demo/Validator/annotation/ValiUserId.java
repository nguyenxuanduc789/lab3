package com.example.demo.Validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.example.demo.Validator.ValiUserIdvalidator;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValiUserIdvalidator.class)
public @interface ValiUserId {
    String message() default "Invalid user ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
