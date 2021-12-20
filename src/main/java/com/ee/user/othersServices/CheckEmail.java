package com.ee.user.othersServices;

import jakarta.validation.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@NotNull
@Size(min = 7)
@Pattern(regexp = "[A-Za-z0-9]*@gmail.com")
@Constraint(validatedBy = {})
//@Constraint(validatedBy = {EmailPattern.class})
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckEmail {
    String message() default "Wrong Email";
    Class <?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String mainName() default "";
    String domain()  default "";
    String sufix()  default "";
}

