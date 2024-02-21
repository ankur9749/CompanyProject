package com.example.demo.validate;

import jakarta.validation.Payload;

public @interface EvenNoOrZero {
	String message() default "Value must be even no or zero";
	Class<?>[] groups() default {};
	Class <? extends Payload>[] payload() default {};
}
