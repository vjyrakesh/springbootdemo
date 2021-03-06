package com.rkasibha.rentabook.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MeasureExecutionTime {
    String value() default "";
}
