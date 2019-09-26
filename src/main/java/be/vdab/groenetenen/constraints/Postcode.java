package be.vdab.groenetenen.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.springframework.messaging.handler.annotation.Payload;

// enkele andere imports
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
//@Constraint(validatedBy = {})
@Constraint(validatedBy = PostcodeValidator.class) 

public @interface Postcode {
	//@OverridesAttribute(constraint = Range.class, name = "message")
	String message() default "{be.vdab.groenetenen.constraints.Postcode.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

