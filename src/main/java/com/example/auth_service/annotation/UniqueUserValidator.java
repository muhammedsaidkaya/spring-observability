package com.example.auth_service.annotation;

import com.example.auth_service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserValidator implements ConstraintValidator<UniqueUser,String> {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void initialize(UniqueUser constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !personRepository.findByIdentificationNumber(s).isPresent();

    }
}