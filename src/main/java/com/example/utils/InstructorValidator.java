package com.example.utils;

import com.example.model.Instructor;
import com.example.model.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InstructorValidator implements
        ConstraintValidator<NotEmptyId, Person> {

    @Override
    public void initialize(NotEmptyId contactNumber) {
    }

    @Override
    public boolean isValid(Person contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.getId()!=0;
    }

}
