package com.rkasibha.rentabook.annotation;

import com.rkasibha.rentabook.validator.CustomNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomNameConstraint {
    String message() default "Name must be atleast 3 chars";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
