package com.rkasibha.springbootdemo.validator;

import com.rkasibha.springbootdemo.annotation.CustomNameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomNameValidator implements ConstraintValidator<CustomNameConstraint, String> {

    @Override
    public void initialize(CustomNameConstraint customName) {

    }

    @Override
    public boolean isValid(String nameField, ConstraintValidatorContext constraintValidatorContext) {
        return (nameField != null) && (nameField.length() > 3);
    }
}
