package com.example.demo.Validator.annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.example.demo.Validator.ValidUsernameValidator;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import  static java.lang.annotation.ElementType.FIELD;
import  static java.lang.annotation.ElementType.TYPE;
import  static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target({TYPE,FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUsernameValidator.class)
public @interface ValidUsername {
    String message()default "username already exits";
    Class<?>[]groups()default {};
    Class <?extends Payload>[] payload() default{};

}
