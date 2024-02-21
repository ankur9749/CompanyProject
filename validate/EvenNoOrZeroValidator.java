package com.example.demo.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EvenNoOrZeroValidator implements ConstraintValidator<EvenNoOrZero, Number> {

	@Override
	public boolean isValid(Number value, ConstraintValidatorContext context) {
		return value == null ||(value.longValue() % 2 == 0);
	}

	@Override
	public void initialize(EvenNoOrZero constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	

}
