package com.tuandev.springboot.mvc.validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator  implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    //assign the value passed in from  annotation
    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }


    // theCode: HTML form data enteded by the user
    // theConstraintValidatorContext : you can place additional error messages here
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }
        else {
            result = true;
        }

        return result;
    }
}






