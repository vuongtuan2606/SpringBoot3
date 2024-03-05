package com.tuandev.springboot.mvc.validationdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Helper class that contains business rules / validation logic
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// Can apply uor annotation to a method or field
@Target({ElementType.METHOD, ElementType.FIELD})
// Ratain this annotation in the java class flie Process it at runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "LUV";

    // define default error message
    public String message() default "must start with LUV";

    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}












