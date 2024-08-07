package com.hocelot.interview.valon;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CuTestVaonImpl.class)
@Documented
public @interface CuTestVaon {

    String message() default "{InterviewTestRequest invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
