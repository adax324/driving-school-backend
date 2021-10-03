package com.example.utils;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InstructorValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyId {
    String message() default "isEmpty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
