package com.example.utils;

import com.example.model.Instructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InstructorValidator implements
        ConstraintValidator<InstructorIsChosen, Instructor> {

    @Override
    public void initialize(InstructorIsChosen contactNumber) {
    }

    @Override
    public boolean isValid(Instructor contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.getId()!=0;
    }

}
